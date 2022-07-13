package andrew.pataleta.features.currency

import andrew.pataleta.core.di.CoreModuleDependencies
import andrew.pataleta.core.di.withFactory
import andrew.pataleta.core.ui.fragment.DynamicNavigationFragment
import andrew.pataleta.domain.model.SymbolItem
import andrew.pataleta.features.currency.databinding.FragmentCurrencyBinding
import andrew.pataleta.features.currency.di.DaggerCurrencyComponent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class CurrencyFragment: DynamicNavigationFragment<FragmentCurrencyBinding>() {

    @Inject
    lateinit var currencyViewModelFactory: CurrencyViewModelFactory

    private val viewModel: CurrencyViewModel
            by viewModels { withFactory(currencyViewModelFactory) }

    override fun getLayoutRes() = R.layout.fragment_currency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initCoreDependentInjection()
    }

    private fun initListeners() {
        dataBinding.currencySelector.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    viewModel.selectSymbol(parent.getItemAtPosition(position) as SymbolItem)
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState->
                    when (uiState) {
                        is CurrencyUiState.Loading -> {
                            Toast.makeText(requireContext(), "Progress...", Toast.LENGTH_LONG).show()
                        }
                        is CurrencyUiState.Error -> {
                            Toast.makeText(requireContext(), uiState.exception.message, Toast.LENGTH_LONG).show()
                        }
                        is CurrencyUiState.Success -> {
                            uiState.currencyItems.let {
                                val adapter = CurrencyAdapter(it,viewModel)
                                dataBinding.items.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
                                dataBinding.items.adapter = adapter
                            }
                            dataBinding.currencySelector.adapter = CurrencySelectorAdapter(requireContext(),uiState.symbolItems,viewModel)
                        }
                    }
                }
            }
        }
        initListeners()
    }

    private fun initCoreDependentInjection() {

        val coreModuleDependencies = EntryPointAccessors.fromApplication(
            requireActivity().applicationContext,
            CoreModuleDependencies::class.java
        )

        DaggerCurrencyComponent.factory().create(
            dependenyModule = coreModuleDependencies,
            fragment = this
        ).inject(this)
    }

}
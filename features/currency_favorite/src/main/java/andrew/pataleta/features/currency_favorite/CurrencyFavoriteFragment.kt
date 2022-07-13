package andrew.pataleta.features.currency_favorite


import andrew.pataleta.core.ui.fragment.DynamicNavigationFragment
import andrew.pataleta.features.currency_favorite.R
import andrew.pataleta.features.currency_favorite.databinding.FragmentCurrencyFavoriteBinding

import android.net.Uri
import android.os.Bundle
import android.view.View

public class CurrencyFavoriteFragment: DynamicNavigationFragment<FragmentCurrencyFavoriteBinding>() {


    override fun getLayoutRes() = R.layout.fragment_currency_favorite

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initCoreDependentInjection()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = dataBinding
    }

    private fun initCoreDependentInjection() {}

}
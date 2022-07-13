package andrew.pataleta.features.currency

import andrew.pataleta.core.di.ViewModelFactory
import andrew.pataleta.domain.usecase.currency.GetCurrencyUseCase

import andrew.pataleta.domain.usecase.symbol.GetSymbolsUseCase
import androidx.lifecycle.SavedStateHandle

import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope



class CurrencyViewModelFactory @Inject constructor(
    private val coroutineScope: CoroutineScope,
    private val getSymbolsUseCase: GetSymbolsUseCase,
    private val getCurrencyUseCase: GetCurrencyUseCase,
    ) : ViewModelFactory<CurrencyViewModel> {

    override fun create(handle: SavedStateHandle): CurrencyViewModel {
        return CurrencyViewModel(
            handle,
            coroutineScope,
            getSymbolsUseCase,
            getCurrencyUseCase
        )
    }
}

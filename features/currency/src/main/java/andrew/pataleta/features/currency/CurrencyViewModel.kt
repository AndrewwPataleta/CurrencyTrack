package andrew.pataleta.features.currency

import andrew.pataleta.domain.model.CurrencyItem
import andrew.pataleta.domain.model.SymbolItem
import andrew.pataleta.domain.usecase.currency.GetCurrencyUseCase
import andrew.pataleta.domain.usecase.symbol.GetSymbolsUseCase
import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val coroutineScope: CoroutineScope,
    private val getSymbolsUseCase: GetSymbolsUseCase,
    private val getCurrencyUseCase: GetCurrencyUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<CurrencyUiState>(CurrencyUiState.Loading)
    val uiState: StateFlow<CurrencyUiState> = _uiState

    init {
        viewModelScope.launch {
            getSymbolsUseCase.getSymbols().collect { items->
               _uiState.value = CurrencyUiState.Success(items, emptyList())
            }
        }
    }

    fun selectSymbol(symbolItem: SymbolItem) {
        viewModelScope.launch {
            getCurrencyUseCase.getCurrency(symbolItem.key).collect { items->

                when (uiState.value) {
                    is CurrencyUiState.Success -> {
                        _uiState.value = CurrencyUiState.Success((uiState.value as CurrencyUiState.Success).symbolItems, items)
                    }
                }

            }
        }
    }
}

sealed class CurrencyUiState {
    data class Success(val symbolItems: List<SymbolItem>, val currencyItems: List<CurrencyItem>): CurrencyUiState()
    object Loading: CurrencyUiState()
    data class Error(val exception: Throwable): CurrencyUiState()
}

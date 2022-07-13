package andrew.pataleta.domain.usecase.currency

import andrew.pataleta.data.repository.CurrencyRepository
import andrew.pataleta.domain.dispatcher.UseCaseDispatchers
import andrew.pataleta.domain.mapper.CurrencyEntityToItemListMapper
import andrew.pataleta.domain.model.CurrencyItem
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetCurrencyUseCase @Inject constructor(
    private val currencyEntityToItemListMapper: CurrencyEntityToItemListMapper,
    private val dispatcherProvider: UseCaseDispatchers,
    private val currencyRepository: CurrencyRepository,
) {

    fun getCurrency(symbol: String): Flow<List<CurrencyItem>> {
        return  flow {
            emit(currencyRepository.getCurrencyRemote(symbol))
        }
        .flowOn(dispatcherProvider.ioDispatcher)
        .map {
            currencyEntityToItemListMapper.map(it)
        }
    }

}

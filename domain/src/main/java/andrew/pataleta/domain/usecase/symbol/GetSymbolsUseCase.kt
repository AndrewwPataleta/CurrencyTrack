package andrew.pataleta.domain.usecase.symbol

import andrew.pataleta.data.repository.CurrencyRepository
import andrew.pataleta.domain.dispatcher.UseCaseDispatchers
import andrew.pataleta.domain.mapper.SymbolEntityToItemListMapper
import andrew.pataleta.domain.model.SymbolItem
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class GetSymbolsUseCase @Inject constructor(
    private val symbolEntityToItemListMapper: SymbolEntityToItemListMapper,
    private val dispatcherProvider: UseCaseDispatchers,
    private val currencyRepository: CurrencyRepository,
) {

    fun getSymbols(): Flow<List<SymbolItem>> {
        return  flow {
            emit(currencyRepository.getSymbolsRemote())
        }
            .flowOn(dispatcherProvider.ioDispatcher)
            .map {
            symbolEntityToItemListMapper.map(it)
        }
    }

}

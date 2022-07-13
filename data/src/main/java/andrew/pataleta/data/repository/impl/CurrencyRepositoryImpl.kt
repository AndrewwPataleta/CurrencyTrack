package andrew.pataleta.data.repository.impl

import andrew.pataleta.data.mapper.currency.CurrencyResponseToListEntityMapper
import andrew.pataleta.data.mapper.currency.SymbolMapDTOtoListEntityMapper
import andrew.pataleta.data.model.local.CurrencyEntity
import andrew.pataleta.data.model.local.SymbolEntity
import andrew.pataleta.data.repository.CurrencyRepository
import andrew.pataleta.data.source.CurrencyLocalDataSource
import andrew.pataleta.data.source.CurrencyRemoteDataSource
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyLocalDataSource: CurrencyLocalDataSource,
    private val currencyRemoteDataSource: CurrencyRemoteDataSource,
    private val currencyResponseToListEntityMapper: CurrencyResponseToListEntityMapper,
    private val symbolMapDTOtoListEntityMapper: SymbolMapDTOtoListEntityMapper
    ): CurrencyRepository {

    override suspend fun getCurrencyLocal(symbol: String): List<CurrencyEntity> {
        return currencyLocalDataSource.getListCurrency()
    }

    override suspend fun getCurrencyRemote(symbol: String): List<CurrencyEntity> {
        return currencyResponseToListEntityMapper.map(currencyRemoteDataSource.getListCurrency(symbol))
    }

    override suspend fun getSymbolsRemote():  List<SymbolEntity> {
        return symbolMapDTOtoListEntityMapper.map(currencyRemoteDataSource.getListSymbols().symbols)
    }

    override suspend fun getSymbolsLocal(): List<SymbolEntity> {
        return listOf()
    }

}
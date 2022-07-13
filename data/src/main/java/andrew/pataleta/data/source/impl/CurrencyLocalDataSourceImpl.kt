package andrew.pataleta.data.source.impl

import andrew.pataleta.data.db.CurrencyDao
import andrew.pataleta.data.model.local.CurrencyEntity
import andrew.pataleta.data.model.local.SymbolEntity
import andrew.pataleta.data.source.CurrencyLocalDataSource
import javax.inject.Inject

class CurrencyLocalDataSourceImpl @Inject constructor(
    private val currencyDao: CurrencyDao
    ): CurrencyLocalDataSource {

    override suspend fun getListCurrency(): List<CurrencyEntity> {
       return currencyDao.getListCurrency()
    }

    override suspend fun getListSymbols(): List<SymbolEntity> {
        return currencyDao.getSymbols()
    }
}
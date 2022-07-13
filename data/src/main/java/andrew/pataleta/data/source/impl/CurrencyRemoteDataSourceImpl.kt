package andrew.pataleta.data.source.impl

import andrew.pataleta.data.api.CurrencyService
import andrew.pataleta.data.db.CurrencyDao
import andrew.pataleta.data.model.local.CurrencyEntity
import andrew.pataleta.data.model.remote.CurrencyDTO
import andrew.pataleta.data.model.remote.ResponseRates
import andrew.pataleta.data.model.remote.ResponseSymbols
import andrew.pataleta.data.source.CurrencyLocalDataSource
import andrew.pataleta.data.source.CurrencyRemoteDataSource
import javax.inject.Inject

class CurrencyRemoteDataSourceImpl @Inject constructor(
    private val currencyService: CurrencyService
    ): CurrencyRemoteDataSource {

    override suspend fun getListCurrency(symbol: String): ResponseRates {
        return currencyService.getCurrency(symbol)
    }

    override suspend fun getListSymbols(): ResponseSymbols {
        return currencyService.getSymbols()
    }
}
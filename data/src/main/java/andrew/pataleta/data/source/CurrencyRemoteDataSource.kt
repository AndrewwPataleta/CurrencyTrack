package andrew.pataleta.data.source

import andrew.pataleta.data.model.remote.CurrencyDTO
import andrew.pataleta.data.model.remote.ResponseRates
import andrew.pataleta.data.model.remote.ResponseSymbols

interface CurrencyRemoteDataSource {

    suspend fun getListCurrency(symbol: String): ResponseRates

    suspend fun getListSymbols(): ResponseSymbols

}
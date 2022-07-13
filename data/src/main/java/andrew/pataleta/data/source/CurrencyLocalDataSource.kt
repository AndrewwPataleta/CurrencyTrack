package andrew.pataleta.data.source

import andrew.pataleta.data.model.local.CurrencyEntity
import andrew.pataleta.data.model.local.SymbolEntity

interface CurrencyLocalDataSource {

    suspend fun getListCurrency(): List<CurrencyEntity>

    suspend fun getListSymbols(): List<SymbolEntity>

}
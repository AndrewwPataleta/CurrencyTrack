package andrew.pataleta.data.repository

import andrew.pataleta.data.model.local.CurrencyEntity
import andrew.pataleta.data.model.local.SymbolEntity

interface CurrencyRepository {

    suspend fun getCurrencyLocal(symbol: String): List<CurrencyEntity>

    suspend fun getCurrencyRemote(symbol: String): List<CurrencyEntity>

    suspend fun getSymbolsRemote(): List<SymbolEntity>

    suspend fun getSymbolsLocal(): List<SymbolEntity>

}
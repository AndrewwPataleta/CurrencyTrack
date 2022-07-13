package andrew.pataleta.data.db

import andrew.pataleta.data.model.local.CurrencyEntity
import andrew.pataleta.data.model.local.SymbolEntity
import androidx.room.Dao
import androidx.room.Query

@Dao
interface CurrencyDao: BaseDao<CurrencyEntity> {


    @Query("Select * from currency")
    fun getListCurrency(): List<CurrencyEntity>

    @Query("Select * from symbol")
    fun getSymbols(): List<SymbolEntity>

}
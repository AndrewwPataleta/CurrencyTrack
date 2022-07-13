package andrew.pataleta.data.db

import andrew.pataleta.data.model.local.CurrencyEntity
import andrew.pataleta.data.model.local.SymbolEntity
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CurrencyEntity::class, SymbolEntity::class], version = 1, exportSchema = false)
abstract class CurrencyDatabase: RoomDatabase() {

    abstract fun currencyDao(): CurrencyDao

}
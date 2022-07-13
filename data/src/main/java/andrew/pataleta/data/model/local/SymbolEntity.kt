package andrew.pataleta.data.model.local

import andrew.pataleta.data.mapper.IEntity
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "symbol")
data class SymbolEntity(
    @PrimaryKey
    val key: String,
    val value: String,
    val isFavorite: Boolean = false
): IEntity

package andrew.pataleta.data.model.local

import andrew.pataleta.data.mapper.IEntity
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class CurrencyEntity(
    @PrimaryKey
    val name: String,
    val value: Double,
    val parent: String,
    val timestamp: Long,
): IEntity

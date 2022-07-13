package andrew.pataleta.data.db

import andrew.pataleta.data.mapper.IEntity
import androidx.room.*

@Dao
interface BaseDao<T: IEntity> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: T): Long

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entities: List<T>): List<Long>

    @Update
    suspend fun update(entity: T): Int

    @Delete
    suspend fun delete(entity: T): Int

}
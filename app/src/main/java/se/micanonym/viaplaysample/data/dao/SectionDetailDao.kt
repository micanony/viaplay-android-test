package se.micanonym.viaplaysample.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import se.micanonym.viaplaysample.data.models.SectionDetailEntity
import se.micanonym.viaplaysample.data.tables.SectionDetailTable

@Dao
interface SectionDetailDao {
    @Query("SELECT * FROM ${SectionDetailTable.TABLE} WHERE ${SectionDetailTable.ID} = :id")
    fun getSectionDetailWithId(id: String): Flow<SectionDetailEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sectionDetailEntity: SectionDetailEntity)
}

package se.micanonym.viaplaysample.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import se.micanonym.viaplaysample.data.models.SectionEntity
import se.micanonym.viaplaysample.data.tables.SectionTable

@Dao
interface SectionDao {
    @Query("SELECT * FROM ${SectionTable.TABLE} ORDER BY ${SectionTable.TITLE}")
    fun getSections(): Flow<List<SectionEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(sectionEntities: List<SectionEntity>)
}

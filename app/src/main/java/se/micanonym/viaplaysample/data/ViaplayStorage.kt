package se.micanonym.viaplaysample.data

import kotlinx.coroutines.flow.Flow
import se.micanonym.viaplaysample.data.models.Id
import se.micanonym.viaplaysample.data.models.SectionDetailEntity
import se.micanonym.viaplaysample.data.models.SectionEntity

interface ViaplayStorage {
    fun getSections(): Flow<List<SectionEntity>>
    suspend fun insertSections(sections: List<SectionEntity>)

    fun getSectionDetailById(id: Id): Flow<SectionDetailEntity?>
    suspend fun insertSectionDetail(sectionDetailEntity: SectionDetailEntity)
}

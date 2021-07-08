package se.micanonym.viaplaysample.data.repositories

import se.micanonym.viaplaysample.data.ViaplayStorage
import se.micanonym.viaplaysample.data.models.Id
import se.micanonym.viaplaysample.data.models.SectionDetailEntity
import se.micanonym.viaplaysample.data.models.SectionEntity
import javax.inject.Inject

class SectionDiskRepository @Inject constructor(
    private val storage: ViaplayStorage
) {
    fun getSections() = storage.getSections()

    suspend fun insertSections(sections: List<SectionEntity>) {
        storage.insertSections(sections)
    }

    fun getSectionDetailById(id: Id) = storage.getSectionDetailById(id)

    suspend fun insertSectionDetail(sectionDetailEntity: SectionDetailEntity) {
        storage.insertSectionDetail(sectionDetailEntity)
    }
}

package se.micanonym.viaplaysample.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import se.micanonym.viaplaysample.data.mapper.SectionDetailMapper
import se.micanonym.viaplaysample.data.mapper.SectionMapper
import se.micanonym.viaplaysample.data.models.Id
import se.micanonym.viaplaysample.data.models.Section
import se.micanonym.viaplaysample.data.models.SectionDetail
import javax.inject.Inject

class SectionRepository @Inject constructor(
    private val sectionApiRepository: SectionApiRepository,
    private val sectionDiskRepository: SectionDiskRepository,
    private val sectionMapper: SectionMapper,
    private val sectionDetailMapper: SectionDetailMapper,
) {
    fun getSections(): Flow<List<Section>> {
        return sectionApiRepository.getSections()
            .map { sections ->
                sectionMapper.toEntities(sections)
            }
            .map { sectionEntities ->
                val sections = sectionMapper.toBusinessObjects(sectionEntities)
                sectionDiskRepository.insertSections(sectionEntities)

                sections.forEach { section ->
                    sectionApiRepository.getSectionDetail(section).collect { sectionDetail ->
                        val sectionDetailEntity = sectionDetailMapper.toEntity(sectionDetail)
                        sectionDiskRepository.insertSectionDetail(sectionDetailEntity)
                    }
                }
                return@map sectionMapper.toBusinessObjects(sectionEntities)
            }
    }

    fun getSectionsFromDisk(): Flow<List<Section>> =
        sectionDiskRepository.getSections().map { entities ->
            sectionMapper.toBusinessObjects(entities)
        }

    fun getSectionDetailById(id: Id): Flow<SectionDetail?> =
        sectionDiskRepository.getSectionDetailById(id).map { sectionDetailEntity ->
            sectionDetailEntity?.let {
                sectionDetailMapper.toBusinessObject(it)
            }
        }
}

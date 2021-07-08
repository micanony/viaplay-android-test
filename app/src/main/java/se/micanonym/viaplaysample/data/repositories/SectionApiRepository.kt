package se.micanonym.viaplaysample.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import se.micanonym.viaplaysample.utils.SectionUtils
import se.micanonym.viaplaysample.data.models.Section
import se.micanonym.viaplaysample.data.models.SectionDetail
import se.micanonym.viaplaysample.data.services.ViaplayService
import javax.inject.Inject

class SectionApiRepository @Inject constructor(
    private val viaplayService: ViaplayService
) {
    fun getSections(): Flow<List<Section>> {
        return flow {
            val sections = viaplayService.getSections().links.sections
            emit(sections)
        }.flowOn(Dispatchers.IO)
    }

    fun getSectionDetail(section: Section): Flow<SectionDetail> {
        return flow {
            val sectionDetail = viaplayService.getSectionDetail(SectionUtils.getName(section))
            emit(sectionDetail)
        }.flowOn(Dispatchers.IO)
    }
}

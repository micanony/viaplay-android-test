package se.micanonym.viaplaysample.data.db

import kotlinx.coroutines.flow.Flow
import se.micanonym.viaplaysample.data.ViaplayRoomDatabase
import se.micanonym.viaplaysample.data.ViaplayStorage
import se.micanonym.viaplaysample.data.models.Id
import se.micanonym.viaplaysample.data.models.SectionDetailEntity
import se.micanonym.viaplaysample.data.models.SectionEntity
import javax.inject.Inject

class ViaplayRoomImpl @Inject constructor(
    private val roomDatabase: ViaplayRoomDatabase
) : ViaplayStorage {
    override fun getSections(): Flow<List<SectionEntity>> =
        roomDatabase.sectionDao().getSections()

    override suspend fun insertSections(sections: List<SectionEntity>) {
        val dao = roomDatabase.sectionDao()
        dao.insertAll(sections)
    }

    override fun getSectionDetailById(id: Id): Flow<SectionDetailEntity?> =
        roomDatabase.sectionDetailDao().getSectionDetailWithId(id.value)

    override suspend fun insertSectionDetail(sectionDetailEntity: SectionDetailEntity) {
        val dao = roomDatabase.sectionDetailDao()
        dao.insert(sectionDetailEntity)
    }
}

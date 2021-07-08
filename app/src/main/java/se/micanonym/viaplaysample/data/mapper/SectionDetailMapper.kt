package se.micanonym.viaplaysample.data.mapper

import se.micanonym.viaplaysample.data.models.Id
import se.micanonym.viaplaysample.data.models.SectionDetail
import se.micanonym.viaplaysample.data.models.SectionDetailEntity
import javax.inject.Inject

class SectionDetailMapper @Inject constructor() : BaseMapper<SectionDetailEntity, SectionDetail> {
    override fun toEntity(bo: SectionDetail) = SectionDetailEntity(
        sectionId = bo.sectionId.value,
        title = bo.title,
        description = bo.description,
    )

    override fun toBusinessObject(entity: SectionDetailEntity) = SectionDetail(
        sectionId = Id(entity.sectionId),
        title = entity.title,
        description = entity.description,
    )
}

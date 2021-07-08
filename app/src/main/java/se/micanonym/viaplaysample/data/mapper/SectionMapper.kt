package se.micanonym.viaplaysample.data.mapper

import se.micanonym.viaplaysample.data.models.Id
import se.micanonym.viaplaysample.data.models.Section
import se.micanonym.viaplaysample.data.models.SectionEntity
import javax.inject.Inject

class SectionMapper @Inject constructor() : BaseMapper<SectionEntity, Section> {
    override fun toEntity(bo: Section): SectionEntity = SectionEntity(
        id = bo.id.value,
        title = bo.title,
        href = bo.href,
    )

    override fun toBusinessObject(entity: SectionEntity): Section = Section(
        id = Id(entity.id),
        title = entity.title,
        href = entity.href,
    )
}

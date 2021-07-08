package se.micanonym.viaplaysample.data.mapper

import se.micanonym.viaplaysample.data.models.BaseEntity

interface BaseMapper<ENTITY : BaseEntity, BO> {
    fun toEntity(bo: BO): ENTITY
    fun toEntities(bos: List<BO>): List<ENTITY> = bos.map { toEntity(it) }
    fun toBusinessObject(entity: ENTITY): BO
    fun toBusinessObjects(entities: List<ENTITY>): List<BO> = entities.map { toBusinessObject(it) }
}

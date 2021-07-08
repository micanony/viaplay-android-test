package se.micanonym.viaplaysample.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import se.micanonym.viaplaysample.data.tables.SectionDetailTable

@Entity(tableName = SectionDetailTable.TABLE)
data class SectionDetailEntity(
    @PrimaryKey
    @ColumnInfo(name = SectionDetailTable.ID)
    val sectionId: String,
    @ColumnInfo(name = SectionDetailTable.TITLE)
    val title: String,
    @ColumnInfo(name = SectionDetailTable.DESCRIPTION)
    val description: String,
) : BaseEntity

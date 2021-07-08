package se.micanonym.viaplaysample.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import se.micanonym.viaplaysample.data.tables.SectionTable

@Entity(tableName = SectionTable.TABLE)
data class SectionEntity(
    @PrimaryKey
    @ColumnInfo(name = SectionTable.ID)
    val id: String,
    @ColumnInfo(name = SectionTable.TITLE)
    val title: String,
    @ColumnInfo(name = SectionTable.HREF)
    val href: String,
) : BaseEntity

package se.micanonym.viaplaysample.data

import androidx.room.Database
import androidx.room.RoomDatabase
import se.micanonym.viaplaysample.data.dao.SectionDao
import se.micanonym.viaplaysample.data.dao.SectionDetailDao
import se.micanonym.viaplaysample.data.models.SectionDetailEntity
import se.micanonym.viaplaysample.data.models.SectionEntity

@Database(
    entities = [
        SectionEntity::class,
        SectionDetailEntity::class
    ],
    version = ViaplayDatabase.VERSION
)
abstract class ViaplayRoomDatabase : RoomDatabase() {
    abstract fun sectionDao(): SectionDao
    abstract fun sectionDetailDao(): SectionDetailDao
}

package se.micanonym.viaplaysample.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import se.micanonym.viaplaysample.data.ViaplayDatabase
import se.micanonym.viaplaysample.data.ViaplayRoomDatabase
import se.micanonym.viaplaysample.data.db.ViaplayRoomImpl
import se.micanonym.viaplaysample.data.ViaplayStorage
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideStorage(roomDatabase: ViaplayRoomDatabase): ViaplayStorage =
        ViaplayRoomImpl(roomDatabase)

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext applicationContext: Context): ViaplayRoomDatabase {
        return Room.databaseBuilder(
           applicationContext,
           ViaplayRoomDatabase::class.java,
           ViaplayDatabase.NAME
        ).build()
    }
}

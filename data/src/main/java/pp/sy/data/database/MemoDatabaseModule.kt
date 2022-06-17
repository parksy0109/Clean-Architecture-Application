package pp.sy.data.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object MemoDatabaseModule {

    @Provides
    @Singleton
    fun provideMemoDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            MemoDatabase::class.java,
            "memo.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMemoDao(memoDatabase: MemoDatabase) = memoDatabase.getMemoDao()
}
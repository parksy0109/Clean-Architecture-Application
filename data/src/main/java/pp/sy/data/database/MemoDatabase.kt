package pp.sy.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pp.sy.data.memo.Memo
import pp.sy.data.memo.MemoDao

@Database(entities = [Memo::class], version = 1, exportSchema = false)
abstract class MemoDatabase : RoomDatabase() {
    abstract fun getMemoDao() : MemoDao
}
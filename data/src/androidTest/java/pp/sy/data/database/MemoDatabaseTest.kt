package pp.sy.data.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import pp.sy.data.memo.Memo
import pp.sy.data.memo.MemoDao
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class SimpleEntityReadWriteTest {
    private lateinit var memoDao: MemoDao
    private lateinit var db: MemoDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, MemoDatabase::class.java).build()
        memoDao = db.getMemoDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertMemo() {
        val title = "test title"
        val content = "test content"
        val memo = Memo(1L, title, content)

        runBlocking {
            memoDao.insert(memo)
            val value  = memoDao.findById(1L)
            assert(title == value.title)
        }
    }
}
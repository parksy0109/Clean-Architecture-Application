package pp.sy.cleanarchitectureapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import pp.sy.data.database.MemoDatabase
import pp.sy.data.memo.Memo
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var memoDatabase: MemoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val memo = Memo(2, "title", "content")

        lifecycleScope.launch{
            memoDatabase.getMemoDao().insert(memo)
            val findValue = memoDatabase.getMemoDao().findById(1)

            Toast.makeText(this@MainActivity, findValue.title,Toast.LENGTH_SHORT).show()
        }

    }
}
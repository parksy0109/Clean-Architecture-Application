package pp.sy.data.memo

import androidx.room.*

@Dao
interface MemoDao {

    @Query(
        "SELECT * FROM memo where memo.id = :id LIMIT 1"
    )
    fun findById(id: Long): Memo

    @Insert
    fun insert(memo: Memo)

    @Update
    fun update(memo: Memo)

    @Delete
    fun delete(memo: Memo)

}
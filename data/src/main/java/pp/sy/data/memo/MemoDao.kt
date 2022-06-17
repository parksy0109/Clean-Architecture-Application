package pp.sy.data.memo

import androidx.room.*

@Dao
interface MemoDao {

    @Query(
        "SELECT * FROM memo where memo.id = :id LIMIT 1"
    )
    suspend fun findById(id: Long): Memo

    @Insert
    suspend fun insert(memo: Memo)

    @Update
    suspend fun update(memo: Memo)

    @Delete
    suspend fun delete(memo: Memo)

}
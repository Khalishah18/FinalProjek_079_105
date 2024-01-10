package com.example.finalprojek_079_105.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface PembeliDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pembeli: Pembeli)

    @Update
    suspend fun update(pembeli: Pembeli)

    @Delete
    suspend fun delete(pembeli: Pembeli)

    @Query("SELECT * from tblPembeli WHERE id= :id")
    fun getPembeli(id: Int): Flow<Pembeli>

    @Query("SELECT * from tblPembeli ORDER BY nama ASC")
    fun getALLPembeli(): Flow<List<Pembeli>>
}
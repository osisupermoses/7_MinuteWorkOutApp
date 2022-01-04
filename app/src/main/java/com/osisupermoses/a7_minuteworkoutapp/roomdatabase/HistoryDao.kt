package com.osisupermoses.a7_minuteworkoutapp.roomdatabase

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert
    suspend fun insert(historyEntity: HistoryEntity)

    @Query("DELETE FROM `history-table`")
    suspend fun deleteAllDates()

    @Query("SELECT * FROM `history-table`")
    fun fetchAllDates(): Flow<List<HistoryEntity>>
}
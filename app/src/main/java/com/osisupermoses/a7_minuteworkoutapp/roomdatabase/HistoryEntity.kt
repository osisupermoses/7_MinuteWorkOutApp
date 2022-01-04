package com.osisupermoses.a7_minuteworkoutapp.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history-table")
data class HistoryEntity(
    @PrimaryKey
    val date: String
)

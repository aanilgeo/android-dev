package com.example.bitfitpart2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SleepEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(sleepEntry: SleepEntry)

    @Query("SELECT * FROM sleep_entries ORDER BY id DESC")
    suspend fun getAllEntries(): List<SleepEntry>
}
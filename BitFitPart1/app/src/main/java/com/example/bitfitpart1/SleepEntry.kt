package com.example.bitfitpart1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sleep_entries")
data class SleepEntry(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: String = "", // Assuming you’re tracking date
    val hoursSlept: Int,
    val feelingScore: Int,  // New field for feeling score
    val notes: String = ""  // New field for optional notes
)

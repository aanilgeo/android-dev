package com.example.bitfitpart1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SleepEntry::class], version = 2)
abstract class BitFitDatabase : RoomDatabase() {
    abstract fun sleepEntryDao(): SleepEntryDao

    companion object {
        @Volatile
        private var INSTANCE: BitFitDatabase? = null

        fun getDatabase(context: Context): BitFitDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BitFitDatabase::class.java,
                    "bitfit_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

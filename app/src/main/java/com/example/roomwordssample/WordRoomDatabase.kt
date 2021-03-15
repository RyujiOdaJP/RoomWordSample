package com.example.roomwordssample

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Word::class], version = 1, exportSchema = false)
abstract class WordRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao

    companion object {
        private var instance: WordRoomDatabase? = null
            get() = field ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    applicationContext,
                    WordRoomDatabase::class.java, "word_database"
                ).build()
            }
    }
}
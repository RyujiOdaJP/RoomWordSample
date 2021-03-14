package com.example.roomwordssample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {
    @Insert
    fun insert(word: Word): Void

    @Query("DELETE FROM word_table")
    fun deleteAll(): Void

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords(): List<Word>

}
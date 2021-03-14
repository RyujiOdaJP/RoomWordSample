package com.example.roomwordssample

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordDao {
    @Insert
    fun insert(word: Word): Void

    @Query("DELETE FROM word_table")
    fun deleteAll(): Void

    //LiveData, which is a lifecycle library class for data observation,
    // can help your app respond to data changes. If you use a return value of type LiveData
    // in your method description, Room generates all necessary code to update
    // the LiveData when the database is updated.
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>

}
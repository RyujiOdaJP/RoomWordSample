package com.example.roomwordssample

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
class Word {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")

    private lateinit var mWord: String

    fun word(word: String) {
        this.mWord = word
    }

    fun getWord(): String {
        return this.mWord
    }

}
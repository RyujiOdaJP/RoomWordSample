package com.example.roomwordssample

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.room.Room


class WordRepository(application: Application, context: Context) {
    private val db = Room.databaseBuilder(
        context.applicationContext,
        WordRoomDatabase::class.java, "word_database"
    ).build()

    private var mWordDao: WordDao = db.wordDao()
    private var mAllWords: LiveData<List<Word>> = mWordDao.getAllWords()

    fun getAllWords(): LiveData<List<Word>> = mAllWords

    fun insert(word: Word) {
        InsertAsyncTask(mWordDao).execute(word)
    }

    companion object {
        @Suppress("DEPRECATION")
        class InsertAsyncTask(private val mAsyncTaskDao: WordDao) : AsyncTask<Word, Void?, Void?>() {

            override fun doInBackground(vararg params: Word):Void =
                mAsyncTaskDao.insert(params[0])
        }
    }


}
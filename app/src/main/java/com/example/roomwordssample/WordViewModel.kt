package com.example.roomwordssample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.invoke.WrongMethodTypeException

class WordViewModel(application: Application) : AndroidViewModel(application) {

    val mRepository = WordRepository(application, application.applicationContext)

    val mAllWord: LiveData<List<Word>> = MutableLiveData(
        listOf<Word>(
            Word()
        )
    )

    fun insert(word: Word) =
        mRepository.insert(word)
}
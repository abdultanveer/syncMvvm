package com.abdul.mvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdul.mvvmapp.data.Word
import com.abdul.mvvmapp.data.WordDao
import com.abdul.mvvmapp.data.WordDb

class MainActivity : AppCompatActivity() {
    lateinit var wordDao: WordDao
    lateinit var wordDb: WordDb


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordDb = WordDb.getNoteDb(this)
        wordDao = wordDb.wordDao()
    }

    fun roomHandler(view: android.view.View) {

        var word: String = "abdul"
        //etTitle.text.toString()
        insertWordAsync(Word("abdul"))
    }

    private fun insertWordAsync(word: Word) {
        var insertTask = InsertNoteAsyncTask(word,wordDao)
        insertTask.execute()
    }
}
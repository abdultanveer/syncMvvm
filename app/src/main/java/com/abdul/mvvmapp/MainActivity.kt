package com.abdul.mvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.abdul.mvvmapp.data.Word
import com.abdul.mvvmapp.data.WordDao
import com.abdul.mvvmapp.data.WordDb

class MainActivity : AppCompatActivity() {
    lateinit var wordDao: WordDao
    lateinit var wordDb: WordDb
    lateinit var etName: EditText
    lateinit var tvRes: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        tvRes = findViewById(R.id.tvRes)

        wordDb = WordDb.getNoteDb(this)
        wordDao = wordDb.wordDao()
    }

    fun roomHandler(view: android.view.View) {

        var word: String = etName.text.toString()
        //etTitle.text.toString()
        insertWordAsync(Word(word))
    }

    private fun insertWordAsync(word: Word) {
        var insertTask = InsertNoteAsyncTask(word,wordDao)
        insertTask.execute()
        etName.setText("")
    }

    fun getData(view: android.view.View) {
        var word: String = etName.text.toString()
        getWordAsync(Word(word))


    }

    private fun getWordAsync(word: Word) {
        var getTask = GetNoteAsyncTask(word,wordDao,tvRes)
        getTask.execute()
        etName.setText("")
    }
}
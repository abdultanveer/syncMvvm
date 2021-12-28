package com.abdul.mvvmapp

import android.os.AsyncTask
import com.abdul.mvvmapp.data.Word
import com.abdul.mvvmapp.data.WordDao

class InsertNoteAsyncTask(var word: Word, var wordDao: WordDao) :AsyncTask<Void,Void,Void>() {


    override fun doInBackground(vararg p0: Void?): Void? {
        wordDao.insert(word)
        return null
    }

}

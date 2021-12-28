package com.abdul.mvvmapp


import android.os.AsyncTask
import android.widget.TextView
import com.abdul.mvvmapp.data.Word
import com.abdul.mvvmapp.data.WordDao
import java.util.*

class GetNoteAsyncTask(var word: Word, var wordDao: WordDao, var tvRes: TextView) :AsyncTask<Void,Void,List<Word>>() {


    override fun doInBackground(vararg p0: Void?): List<Word>? {
       return wordDao.findNote(word.title)

    }

    override fun onPostExecute(result: List<Word>?) {
        super.onPostExecute(result)
        //var array = arrayOf(result)
        tvRes.setText(
            result?.get(0)?.title)

    }

}

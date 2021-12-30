package com.abdul.mvvmapp.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abdul.mvvmapp.R

class FragsActivity : AppCompatActivity(),HeadlinesFragment.HeadlineClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frags)
    }

    override fun onHeadlineClick(headline: String?) { //as to typecast
        var newsFragment:NewsItemFrag = supportFragmentManager.findFragmentById(R.id.newsFragment) as NewsItemFrag
        newsFragment.setData(headline)
    }
}
package com.abdul.mvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var data = arrayOf("abdul","ansari","manaswi","zaid","ravi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recyclerView = findViewById(R.id.recyclerView)
        var namesAdapter = NamesAdapter(data)
    }
}
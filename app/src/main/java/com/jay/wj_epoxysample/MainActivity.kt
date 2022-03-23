package com.jay.wj_epoxysample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.jay.wj_epoxysample.utils.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private val mainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv)
        recyclerView.adapter = mainAdapter

        mainAdapter.run {
            addItem(createFirstHeader())
            addItem(createFirstHorizontal())
            addItem(createSecondHeader())
            addItem(createSecondHorizontal())
            addItem(createThirdHeader())
            addItem(createThirdHorizontal())
            addAll(createLastest())
        }
    }

}
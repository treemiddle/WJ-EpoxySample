package com.jay.wj_epoxysample.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jay.wj_epoxysample.ui.epoxy.EpoxyActivity
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.utils.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton

    private val mainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv)
        fab = findViewById(R.id.fab)
        recyclerView.adapter = mainAdapter

        createItems()
        initListeners()
    }

    private fun createItems() {
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

    private fun initListeners() {
        fab.setOnClickListener { startActivity(Intent(this, EpoxyActivity::class.java)) }
    }

}
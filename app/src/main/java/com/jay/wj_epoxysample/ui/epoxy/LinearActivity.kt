package com.jay.wj_epoxysample.ui.epoxy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.ui.epoxy.controllers.LinearController
import com.jay.wj_epoxysample.ui.epoxy.model.EpoxySampleData

class LinearActivity : AppCompatActivity() {

    private lateinit var epoxyRecyclerView: EpoxyRecyclerView
    private val epoxyController by lazy { LinearController(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy_recycler_view)

        epoxyRecyclerView = findViewById(R.id.rv_epoxy)
        epoxyRecyclerView.run {
            layoutManager = LinearLayoutManager(this@LinearActivity)
            adapter = epoxyController.adapter
        }

        createModels()
    }

    private fun createModels() {
        val list = mutableListOf<EpoxySampleData>().apply {
            for (i in 1..100) {
                add(
                    EpoxySampleData(
                        name = "my name: $i",
                        first = "first: $i",
                        second = "second: $i",
                        third = "third: $i",
                        title = "this is title: $i"
                    )
                )
            }
        }

        epoxyController.setData(list)
    }
}
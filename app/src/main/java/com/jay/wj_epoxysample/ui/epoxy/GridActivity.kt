package com.jay.wj_epoxysample.ui.epoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.ui.epoxy.controllers.GridController
import com.jay.wj_epoxysample.ui.epoxy.model.EpoxySampleData

class GridActivity : AppCompatActivity() {

    private lateinit var epoxyRecyclerView: EpoxyRecyclerView
    private val epoxyController by lazy { GridController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy_recycler_view)

        epoxyRecyclerView = findViewById(R.id.rv_epoxy)
        epoxyRecyclerView.run {
            layoutManager = GridLayoutManager(this@GridActivity, 3).apply {
                spanSizeLookup = epoxyController.spanSizeLookup
            }
            adapter = epoxyController.adapter
        }

        createModels()
    }

    private fun createModels() {
        val list = mutableListOf<EpoxySampleData>().apply {
            for (i in 0..50) {
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
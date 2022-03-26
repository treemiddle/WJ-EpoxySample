package com.jay.wj_epoxysample.ui.epoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.ui.epoxy.controllers.LoadMoreController
import com.jay.wj_epoxysample.ui.epoxy.model.EpoxySampleData
import com.jay.wj_epoxysample.utils.EndlessRecyclerViewScrollListener

class LoadMoreActivity : AppCompatActivity() {

    private lateinit var epoxyRecyclerView: RecyclerView
    private val epoxyController by lazy { LoadMoreController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy_recycler_view)

        epoxyRecyclerView = findViewById(R.id.rv_epoxy)
        epoxyRecyclerView.run {
            layoutManager = GridLayoutManager(this@LoadMoreActivity, 3).apply {
                spanSizeLookup = epoxyController.spanSizeLookup
            }
            adapter = epoxyController.adapter

            addOnScrollListener(object : EndlessRecyclerViewScrollListener() {
                override fun onLoadMore(view: RecyclerView) {
                    epoxyController.showLoadMore()
                    Handler(Looper.getMainLooper()).postDelayed({
                        createModels(true)
                    }, 1500)
                }
            })
        }

        createModels()
    }

    private fun createModels(isMore: Boolean = false) {
        val list = mutableListOf<EpoxySampleData>().apply {
            for (i in 0..30) {
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

        if (isMore) {
            epoxyController.addItems(list)
        } else {
            epoxyController.setItems(list)
        }
    }


}
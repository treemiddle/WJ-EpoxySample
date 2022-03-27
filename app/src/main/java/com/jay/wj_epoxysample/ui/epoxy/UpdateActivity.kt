package com.jay.wj_epoxysample.ui.epoxy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.ui.epoxy.controllers.UpdateController
import com.jay.wj_epoxysample.ui.epoxy.model.EpoxySampleData

class UpdateActivity : AppCompatActivity() {

    private lateinit var epoxyRecyclerView: RecyclerView
    private val epoxyController by lazy {
        object : UpdateController() {
            override fun onUpdateItemClicked() {
                shuffleData()
            }
        }
    }

    private val data = mutableListOf<EpoxySampleData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy_recycler_view)

        epoxyRecyclerView = findViewById(R.id.rv_epoxy)
        epoxyRecyclerView.run {
            layoutManager = LinearLayoutManager(this@UpdateActivity)
            adapter = epoxyController.adapter
        }

        createModels()
    }

    private fun createModels() {
        for (i in 0..2) {
            data.add(
                EpoxySampleData(
                    name = "my name: $i",
                    first = "first: $i",
                    second = "second: $i",
                    third = "third: $i",
                    title = "this is title: $i"
                )
            )
        }

        epoxyController.setData(data)
    }

    private fun shuffleData() {
        val dataSize = epoxyController.currentData?.size
        val textRandom = (0..100).random()

        dataSize?.let {
            val random = (0 until it).random()
            data[random] = epoxyController.currentData!![random].copy(
                name = "copy name: $textRandom",
                first = "copy first: $textRandom",
                second = "copy second: $textRandom",
                third = "copy third: $textRandom",
                title = "copy title: $textRandom"
            )

            epoxyController.setData(data)
        }
    }

}
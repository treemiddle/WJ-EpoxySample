package com.jay.wj_epoxysample.ui.epoxy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.EpoxyRecyclerView
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.ui.epoxy.model.Header

class EpoxyActivity : AppCompatActivity() {

    private lateinit var epoxyRecyclerView: EpoxyRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy)

        epoxyRecyclerView = findViewById(R.id.rv_epoxy)

        createModels()
    }

    private fun createModels() {
        epoxyRecyclerView.withModels {
            for (i in 0..99) {
                Header("test header: $i")
                    .id("header: $i")
                    .addTo(this)
            }
        }
    }

}
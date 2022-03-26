package com.jay.wj_epoxysample.ui.epoxy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.carousel
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.EpoxyViewFirstModel_
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.EpoxyViewSecondModel_
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.ItemEpoxyHolder_
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.itemEpoxyHolder
import com.jay.wj_epoxysample.ui.epoxy.epoxy_model.EpoxyDataClass
import com.jay.wj_epoxysample.ui.epoxy.model.EpoxySampleData

class SamethingActivity : AppCompatActivity() {

    private lateinit var epoxyRecyclerView: EpoxyRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy_recycler_view)

        epoxyRecyclerView = findViewById(R.id.rv_epoxy)
        epoxyRecyclerView.run {
            layoutManager = LinearLayoutManager(this@SamethingActivity)
        }

        epoxyRecyclerView.withModels {
            EpoxyDataClass(
                EpoxySampleData(
                    name = "",
                    first = "",
                    second = "",
                    third = "",
                    title = "title 1"
                )
            )
                    .id("epoxy sample id: 1")
                    .addTo(this)

            carousel {
                id("carousel 1")
                models(createFirstHorizontalScrollModels())
            }

            EpoxyDataClass(
                EpoxySampleData(
                    name = "",
                    first = "",
                    second = "",
                    third = "",
                    title = "title 2"
                )
            )
                .id("epoxy sample id: 2")
                .addTo(this)

            carousel {
                id("carousel 2")
                models(createSecondHorizontalScrollModels())
            }

            EpoxyDataClass(
                EpoxySampleData(
                    name = "",
                    first = "",
                    second = "",
                    third = "",
                    title = "title 3"
                )
            )
        }
    }

    private fun getRandomSize() = (3..10).random()

    private fun createEpoxySampleData(): List<EpoxySampleData> {
        return mutableListOf<EpoxySampleData>().apply {
            for (i in 0..getRandomSize()) {
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
    }

    private fun createFirstHorizontalScrollModels(): List<EpoxyViewFirstModel_> {
        val list = createEpoxySampleData()

        return list.mapIndexed { i, item ->
            EpoxyViewFirstModel_()
                .id("id: $i")
                .firstText(item.first)
                .secondText(item.second)
                .thirdText(item.third)
        }
    }

    private fun createSecondHorizontalScrollModels(): List<EpoxyViewSecondModel_> {
        val list = createEpoxySampleData()

        return list.mapIndexed { i, item ->
            EpoxyViewSecondModel_()
                .id("id: $i")
                .description(item.name)
        }
    }

}
package com.jay.wj_epoxysample.ui.epoxy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.carousel
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.EpoxyViewFirstModel_
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.EpoxyViewSecondModel_
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.epoxyViewThird
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
            //layoutManager = LinearLayoutManager(this@SamethingActivity)
        }

        epoxyRecyclerView.withModels {
            epoxyRecyclerView.layoutManager = GridLayoutManager(this@SamethingActivity, 2).apply {
                spanSizeLookup = this@withModels.spanSizeLookup
            }

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
                .spanSizeOverride(EpoxyModel.SpanSizeOverrideCallback { totalSpanCount, position, itemCount ->
                    return@SpanSizeOverrideCallback 2
                })
                .addTo(this)

            carousel {
                id("carousel 1")
                models(createFirstHorizontalScrollModels())
//                    spanSizeOverride(EpoxyModel.SpanSizeOverrideCallback { _, _, _ ->
//                        return@SpanSizeOverrideCallback 2
//                    })
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
                .spanSizeOverride { _, _, _ -> 2 }
                .addTo(this)

            carousel {
                id("carousel 2")
                models(createSecondHorizontalScrollModels())
//                spanSizeOverride(EpoxyModel.SpanSizeOverrideCallback { _, _, _ ->
//                    return@SpanSizeOverrideCallback 2
//                })
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
                .id("epoxy sample id: 2")
                .spanSizeOverride { _, _, _ -> 2 }
                .addTo(this)

            for (i in 0..7) {
                epoxyViewThird {
                    id("view third id: $i")
                    title("title? -> :$i")
                    spanSizeOverride { _, _, _ -> 1 }
                }
            }

            for (i in 0..99) {
                itemEpoxyHolder {
                    id("holder id: $i")
                    name("my name: $i")
                    spanSizeOverride { _, _, _ -> 2 }
                }
            }
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
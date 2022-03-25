package com.jay.wj_epoxysample.ui.epoxy.controllers

import android.content.Context
import android.widget.Toast
import com.airbnb.epoxy.TypedEpoxyController
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.epoxyViewFirst
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.itemEpoxyHolder
import com.jay.wj_epoxysample.ui.epoxy.epoxy_model.EpoxyDataClass
import com.jay.wj_epoxysample.ui.epoxy.model.EpoxySampleData

class LinearController(
    private val context: Context
) : TypedEpoxyController<List<EpoxySampleData>>() {

    override fun buildModels(data: List<EpoxySampleData>?) {
        data?.let {
            it.forEachIndexed { i, item ->
                itemEpoxyHolder {
                    id("item epoxy id: $i")
                    name(item.name)
                }
                epoxyViewFirst {
                    id("epoxy first id: $i")
                    firstText(item.first)
                    secondText(item.second)
                    thirdText(item.third)
                    listener { _ ->
                        Toast.makeText(
                            this@LinearController.context,
                            "clicked: $item",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
                EpoxyDataClass(item)
                    .id("epoxy data class id: $i")
                    .addTo(this)
            }
        }
    }

}
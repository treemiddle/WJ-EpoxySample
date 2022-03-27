package com.jay.wj_epoxysample.ui.epoxy.controllers

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.TypedEpoxyController
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.epoxyViewFirst
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.itemEpoxyHolder
import com.jay.wj_epoxysample.ui.epoxy.model.EpoxySampleData

class GridController : TypedEpoxyController<List<EpoxySampleData>>() {

    override fun buildModels(data: List<EpoxySampleData>?) {
        data?.let {
            it.forEachIndexed { i, item ->
                if (i % 7 == 0) {
                    itemEpoxyHolder {
                        id("item epoxy holder id: $i")
                        name(item.name)
                        spanSizeOverride(EpoxyModel.SpanSizeOverrideCallback { totalSpanCount, position, itemCount ->
                            return@SpanSizeOverrideCallback 3
                        })
                    }
                } else {
                    epoxyViewFirst {
                        id("epoxy first view id: $i")
                        firstText(item.first)
                        secondText(item.second)
                        thirdText(item.third)
                        spanSizeOverride(EpoxyModel.SpanSizeOverrideCallback { totalSpanCount, position, itemCount ->
                            return@SpanSizeOverrideCallback 1
                        })
                    }
                }
            }
        }
    }

}
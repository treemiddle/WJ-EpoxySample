package com.jay.wj_epoxysample.ui.epoxy.controllers

import com.airbnb.epoxy.TypedEpoxyController
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.epoxyViewFirst
import com.jay.wj_epoxysample.ui.epoxy.epoxy_holder.updateButton
import com.jay.wj_epoxysample.ui.epoxy.model.EpoxySampleData

open class UpdateController : TypedEpoxyController<List<EpoxySampleData>>()  {

    override fun buildModels(data: List<EpoxySampleData>?) {
        updateButton {
            id("update button id")
            buttonTitle("UPDATE ITEM")
            listener { _ ->
                this@UpdateController.onUpdateItemClicked()
            }
        }
        data?.let {
            it.forEachIndexed { i, item ->
                epoxyViewFirst {
                    id("epoxy view id: $i")
                    firstText(item.first)
                    secondText(item.second)
                    thirdText(item.third)
                    listener { _ -> println("clicked: $item") }
                    spanSizeOverride { totalSpanCount, position, itemCount ->
                        return@spanSizeOverride 1
                    }
                }
            }
        }
    }

    open fun onUpdateItemClicked() { }

}
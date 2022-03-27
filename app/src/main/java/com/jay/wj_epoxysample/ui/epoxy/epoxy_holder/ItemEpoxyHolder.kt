package com.jay.wj_epoxysample.ui.epoxy.epoxy_holder

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.ui.epoxy.kotlin.KotlinEpoxyHolder

@EpoxyModelClass(layout = R.layout.epoxy_view_text)
abstract class ItemEpoxyHolder : EpoxyModelWithHolder<ItemEpoxyHolder.Holder>() {

    @EpoxyAttribute lateinit var name: String

    override fun bind(holder: Holder) = with(holder) {
        tvName.text = name
    }

    class Holder : KotlinEpoxyHolder() {
        val tvName by bind<TextView>(R.id.tv)
    }

}
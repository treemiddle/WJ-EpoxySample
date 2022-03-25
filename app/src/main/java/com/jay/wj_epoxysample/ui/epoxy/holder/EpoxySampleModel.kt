package com.jay.wj_epoxysample.ui.epoxy.holder

import android.widget.TextView
import android.widget.Toast
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.ui.epoxy.KotlinEpoxyHolder

//@EpoxyModelClass(layout = R.layout.epoxy_item_holder)
//abstract class EpoxySampleModel : EpoxyModelWithHolder<EpoxySampleModel.EpoxyTextHolder>() {
//
//    @EpoxyAttribute lateinit var title: String
//
//    override fun bind(holder: EpoxyTextHolder) {
//        holder.titleView.text = title
//        holder.titleView.setOnClickListener { Toast.makeText(holder.titleView.context, "clicked", Toast.LENGTH_SHORT).show() }
//    }
//
//    class EpoxyTextHolder : KotlinEpoxyHolder() {
//        val titleView by bind<TextView>(R.id.title)
//    }
//
//}
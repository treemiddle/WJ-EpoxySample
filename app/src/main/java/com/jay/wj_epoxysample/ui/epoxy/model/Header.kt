package com.jay.wj_epoxysample.ui.epoxy.model

import android.widget.TextView
import android.widget.Toast
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.ui.epoxy.KotlinModel

data class Header(val title: String) : KotlinModel(R.layout.epoxy_item_holder) {

    private val tvTitle by bind<TextView>(R.id.title)

    override fun bind() {
        tvTitle.text = title
        tvTitle.setOnClickListener {
            Toast.makeText(tvTitle.context, "clicked: $title", Toast.LENGTH_SHORT).show()
        }
    }

}
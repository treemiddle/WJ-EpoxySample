package com.jay.wj_epoxysample

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jay.wj_epoxysample.model.*

class TextHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvTitle: TextView = itemView.findViewById(R.id.tv_header)

    fun bind(item: BaseModel) {
        tvTitle.text = (item as? TextModel)?.title
    }
}

class HorizontalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val rvHorizontal: RecyclerView = itemView.findViewById(R.id.rv_item)

    fun bind(item: List<FeedModel>, isGrid: Boolean = false) {
        if (isGrid) {
            rvHorizontal.layoutManager = GridLayoutManager(rvHorizontal.context, 2)
        }

        rvHorizontal.adapter = HorizontalAdapter().apply {
            setAllItems(item)
        }
    }
}

class FristFeedHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val iv: ImageView = itemView.findViewById(R.id.iv_feed)
    private val tvFirst: TextView = itemView.findViewById(R.id.tv_first)
    private val tvSecond: TextView = itemView.findViewById(R.id.tv_second)
    private val tvThrid: TextView = itemView.findViewById(R.id.tv_third)

    fun bind(item: FeedModel) {
        (item as FirstFeed).run {
            tvFirst.text = this.firstText
            tvSecond.text = this.secondText
            tvThrid.text = this.thridText
        }
    }
}

class SecondFeedHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val iv: ImageView = itemView.findViewById(R.id.iv)
    private val tvDesc: TextView = itemView.findViewById(R.id.tv)

    fun bind(item: FeedModel) {
        (item as SecondFeed).run { tvDesc.text = this.description }
    }
}

class ThirdFeedHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvTitle: TextView = itemView.findViewById(R.id.tv_title)

    fun bind(item: FeedModel) {
        (item as ThirdFeed).run { tvTitle.text = this.title }
    }
}
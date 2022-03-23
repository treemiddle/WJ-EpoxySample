package com.jay.wj_epoxysample

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jay.wj_epoxysample.model.FeedModel
import com.jay.wj_epoxysample.model.FirstFeed
import com.jay.wj_epoxysample.model.SecondFeed
import com.jay.wj_epoxysample.model.ThirdFeed

class HorizontalAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<FeedModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_FIRST -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_feed_first, parent, false)

                FristFeedHolder(view)
            }
            TYPE_SECOND -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_feed_second, parent, false)

                SecondFeedHolder(view)
            }
            TYPE_THIRD -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_feed_third, parent, false)

                ThirdFeedHolder(view)
            }
            else -> throw IllegalStateException("can't find viewtype: ${javaClass.simpleName}")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FristFeedHolder -> holder.bind(data[position])
            is SecondFeedHolder -> holder.bind(data[position])
            is ThirdFeedHolder -> holder.bind(data[position])
        }
    }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int) = when (data[position]) {
        is FirstFeed -> TYPE_FIRST
        is SecondFeed -> TYPE_SECOND
        is ThirdFeed -> TYPE_THIRD
        else -> TYPE_FIRST
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setAllItems(item: List<FeedModel>) {
        item.run { this.forEach { data.add(it) } }
        notifyDataSetChanged()
    }

    companion object {
        const val TYPE_FIRST = 0
        const val TYPE_SECOND = 1
        const val TYPE_THIRD = 2
    }

}
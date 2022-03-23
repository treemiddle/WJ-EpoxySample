package com.jay.wj_epoxysample

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jay.wj_epoxysample.model.BaseModel
import com.jay.wj_epoxysample.model.HorizontalModel
import com.jay.wj_epoxysample.model.HorizontalType
import com.jay.wj_epoxysample.model.TextModel
import com.jay.wj_epoxysample.utils.createFirstFeeds
import com.jay.wj_epoxysample.utils.createSecondFeeds
import com.jay.wj_epoxysample.utils.createThirdFeeds

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = mutableListOf<BaseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TEXT -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_header_text, parent, false)

                TextHolder(view)
            }
            TYPE_HORIZONTAL -> {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.item_recyclerview, parent, false)

                HorizontalHolder(view)
            }
            else -> throw IllegalStateException("can't find viewtype: ${javaClass.simpleName}")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TextHolder -> {
                holder.bind(data[position] as TextModel)
            }
            is HorizontalHolder -> {
                val horizontalType = data[position] as HorizontalModel

                when (horizontalType.type) {
                    HorizontalType.FIRST -> holder.bind(createFirstFeeds())
                    HorizontalType.SECOND -> holder.bind(createSecondFeeds())
                    HorizontalType.THIRD -> holder.bind(createThirdFeeds(), true)
                }
            }
        }
    }

    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int) = when (data[position]) {
        is TextModel -> { TYPE_TEXT }
        is HorizontalModel -> { TYPE_HORIZONTAL }
        else -> TYPE_TEXT
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(items: BaseModel) {
        data.add(items)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addAll(items: List<BaseModel>) {
        items.forEach { data.add(it) }
        notifyDataSetChanged()
    }

    companion object {
        const val TYPE_TEXT = 0
        const val TYPE_HORIZONTAL = 1
    }

}
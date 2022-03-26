package com.jay.wj_epoxysample.ui.epoxy.epoxy_holder

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.databinding.EpoxyViewSecondBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class EpoxyViewSecond @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding by lazy {
        EpoxyViewSecondBinding.inflate(LayoutInflater.from(context), this, true)
    }

    @ModelProp
    fun setDescription(text: String) {
        binding.tv.text = text
    }

}
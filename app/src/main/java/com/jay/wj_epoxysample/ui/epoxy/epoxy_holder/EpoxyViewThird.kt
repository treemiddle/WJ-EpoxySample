package com.jay.wj_epoxysample.ui.epoxy.epoxy_holder

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.jay.wj_epoxysample.databinding.EpoxyViewThirdBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class EpoxyViewThird @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding by lazy {
        EpoxyViewThirdBinding.inflate(LayoutInflater.from(context), this, true)
    }

    @TextProp
    fun setTitle(text: CharSequence) {
        binding.tvTitle.text = text
    }

}
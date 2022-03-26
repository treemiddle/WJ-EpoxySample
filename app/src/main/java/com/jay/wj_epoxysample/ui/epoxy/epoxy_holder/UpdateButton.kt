package com.jay.wj_epoxysample.ui.epoxy.epoxy_holder

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.jay.wj_epoxysample.databinding.EpoxyViewButtonBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class UpdateButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val binding by lazy {
        EpoxyViewButtonBinding.inflate(LayoutInflater.from(context), this, true)
    }

    var listener: OnClickListener? = null
        @CallbackProp set

    @ModelProp
    fun setButtonTitle(text: CharSequence) {
        binding.btn.text = text
    }

    @AfterPropsSet
    fun useProps() {
        binding.btn.setOnClickListener(listener)
    }

}
package com.jay.wj_epoxysample.ui.epoxy.epoxy_holder

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.jay.wj_epoxysample.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class EpoxyViewFirst @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val tvFirst: TextView
    private val tvSecond: TextView
    private val tvThird: TextView
    private val container: ConstraintLayout

    var listener: OnClickListener? = null
        @CallbackProp set

    init {
        inflate(context, R.layout.epoxy_view_first, this)
        orientation = VERTICAL
        tvFirst = findViewById(R.id.tv_first)
        tvSecond = findViewById(R.id.tv_second)
        tvThird = findViewById(R.id.tv_third)
        container = findViewById(R.id.container)
    }

    @ModelProp
    fun setFirstText(text: String) {
        tvFirst.text = text
    }

    @ModelProp
    fun setSecondText(text: String) {
        tvSecond.text = text
    }

    @ModelProp
    fun setThirdText(text: String) {
        tvThird.text = text
    }

    @AfterPropsSet
    fun useProps() {
        container.setOnClickListener(listener)
    }

}
package com.jay.wj_epoxysample.ui.epoxy.epoxy_model

import android.widget.TextView
import android.widget.Toast
import com.jay.wj_epoxysample.R
import com.jay.wj_epoxysample.ui.epoxy.kotlin.KotlinModel
import com.jay.wj_epoxysample.ui.epoxy.model.EpoxySampleData

/**
 * 데이터 클래스를 활용한 예제
 * KotlinModel을 상속 받아야한다.
 * annotation이 따로 필요하지 않으며 Epoxy가 diffing에 필요한 equals/hashcode를 생성하는데 필요하다.
 *
 * -> 주석이나 코드 생성없이 코틀린에서 epoxy 모델을 사용하기 위한 패턴 (일반적으로 generated 되지 않는다)
 */
data class EpoxyDataClass(
    private val sampleData: EpoxySampleData
) : KotlinModel(R.layout.epoxy_view_data_class) {

    private val tvTitle by bind<TextView>(R.id.title)

    override fun bind() {
        tvTitle.text = sampleData.title
        tvTitle.setOnClickListener {
            Toast.makeText(tvTitle.context, "clicked: ${sampleData.title}", Toast.LENGTH_SHORT).show()
        }
    }

}
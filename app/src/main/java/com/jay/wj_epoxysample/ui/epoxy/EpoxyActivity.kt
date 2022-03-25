package com.jay.wj_epoxysample.ui.epoxy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jay.wj_epoxysample.R

class EpoxyActivity : AppCompatActivity() {

    private val btnLinear: Button by lazy { findViewById(R.id.btn_linear) }
    private val btnGrid: Button by lazy { findViewById(R.id.btn_grid) }
    private val btnPaging: Button by lazy { findViewById(R.id.btn_paging) }
    private val btnUpdate: Button by lazy { findViewById(R.id.btn_update) }
    private val btnSamething: Button by lazy { findViewById(R.id.btn_samething) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_epoxy)

        initListeners()
    }

    private fun initListeners() {
        btnLinear.setOnClickListener { moveTo(LinearActivity::class.java) }
        btnGrid.setOnClickListener { moveTo(GridActivity::class.java) }
        btnPaging.setOnClickListener { moveTo(PagingActivity::class.java) }
        btnUpdate.setOnClickListener { moveTo(UpdateActivity::class.java) }
        btnSamething.setOnClickListener { moveTo(SamethingActivity::class.java) }
    }

    private fun moveTo(className: Class<*>) {
        startActivity(Intent(this, className))
    }

}
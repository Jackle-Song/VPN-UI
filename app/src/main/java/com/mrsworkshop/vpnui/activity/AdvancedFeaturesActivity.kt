package com.mrsworkshop.vpnui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.databinding.ActivityAdvancedFeaturesBinding

class AdvancedFeaturesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdvancedFeaturesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvancedFeaturesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        setupComponentListener()
    }

    private fun initUI() {
        binding.layoutAdvancedFeaturesHeader.txtActivityTitle.text = getString(R.string.advanced_features_activity_title)
    }

    private fun setupComponentListener() {
        binding.layoutAdvancedFeaturesHeader.imgBackBtn.setOnClickListener {
            finish()
        }
    }
}
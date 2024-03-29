package com.mrsworkshop.vpnui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.databinding.ActivityForAllDevicesBinding

class ForAllDevicesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForAllDevicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForAllDevicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        setupComponentListener()
    }

    private fun initUI() {
        binding.layoutForAllDevicesHeader.txtActivityTitle.text = getString(R.string.for_all_devices_activity_title)
    }

    private fun setupComponentListener() {
        binding.layoutForAllDevicesHeader.imgBackBtn.setOnClickListener {
            finish()
        }
    }
}
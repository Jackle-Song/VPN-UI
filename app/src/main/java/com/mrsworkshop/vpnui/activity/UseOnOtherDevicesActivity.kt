package com.mrsworkshop.vpnui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.databinding.ActivityUseOnOtherDevicesBinding

class UseOnOtherDevicesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUseOnOtherDevicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUseOnOtherDevicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        setupComponentListener()
    }

    /**
     * private function
     */

    private fun initUI() {
        binding.layoutUseOtherDevicesHeader.txtActivityTitle.text = getString(R.string.use_other_activity_title)
    }

    private fun setupComponentListener() {
        binding.cardViewForAllDevices.setOnClickListener {
            val intent = Intent(this@UseOnOtherDevicesActivity, ForAllDevicesActivity::class.java)
            startActivity(intent)
        }

        binding.layoutUseOtherDevicesHeader.imgBackBtn.setOnClickListener {
            finish()
        }
    }
}
package com.mrsworkshop.vpnui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
     private lateinit var binding: ActivityNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        setupComponentListener()
    }

    /**
     * private function
     */

    private fun initUI() {
        binding.layoutNotificationHeader.txtActivityTitle.text = getString(R.string.notification_activity_notification_title)
    }

    private fun setupComponentListener() {
        binding.layoutNotificationHeader.imgBackBtn.setOnClickListener {
            finish()
        }
    }
}
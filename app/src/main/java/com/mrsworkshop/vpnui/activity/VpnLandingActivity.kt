package com.mrsworkshop.vpnui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.mrsworkshop.vpnui.R

class VpnLandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vpn_landing)

        initUI()
    }

    private fun initUI() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@VpnLandingActivity, PrivacyActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }
}
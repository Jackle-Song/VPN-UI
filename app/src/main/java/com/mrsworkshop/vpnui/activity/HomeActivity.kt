package com.mrsworkshop.vpnui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.databinding.ActivityHomeScreenBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding

    private var isVpnOn : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupComponentListener()
    }

    /**
     * private function
     */

    private fun setupComponentListener() {
        binding.imgVpnOnOffButton.setOnClickListener {
            if (isVpnOn) {
                binding.imgVpnOnOffButton.setImageResource(R.drawable.ic_off_button)
                binding.txtVpnOnOffTitle.text = getString(R.string.home_activity_vpn_off_title)
                binding.txtVpnOnOffTitle.setTextColor(ContextCompat.getColor(this, R.color.light_grey_ba))

                isVpnOn = false
            } else {
                binding.imgVpnOnOffButton.setImageResource(R.drawable.ic_on_button)
                binding.txtVpnOnOffTitle.text = getString(R.string.home_activity_vpn_on_title)
                binding.txtVpnOnOffTitle.setTextColor(ContextCompat.getColor(this, R.color.blue_08))

                isVpnOn = true
            }
        }

        binding.imgMenuButton.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        binding.imgNotificationHome.setOnClickListener {
            val intent = Intent(this@HomeActivity, NotificationActivity::class.java)
            startActivity(intent)
        }

        binding.layoutSelectLocation.setOnClickListener {
            val intent = Intent(this@HomeActivity, SelectLocationActivity::class.java)
            startActivity(intent)
        }

        binding.layoutSideBar.layoutNavUseOnOtherDevices.setOnClickListener {
            val intent = Intent(this@HomeActivity, UseOnOtherDevicesActivity::class.java)
            startActivity(intent)
        }

        binding.layoutSideBar.layoutNavLanguage.setOnClickListener {
            val intent = Intent(this@HomeActivity, LanguageOptionsActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.mrsworkshop.vpnui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.adapter.PrivacyViewAdapter
import com.mrsworkshop.vpnui.core.CoreEnum
import com.mrsworkshop.vpnui.databinding.ActivityPrivacyBinding

class PrivacyActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPrivacyBinding
    private lateinit var privacyViewAdapter: PrivacyViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        setupComponentListener()
    }

    private fun initUI() {
        privacyViewAdapter = PrivacyViewAdapter(this@PrivacyActivity)
        binding.viewPagerPrivacy.adapter = privacyViewAdapter
        binding.viewPagerPrivacy.isUserInputEnabled = false
    }

    private fun setupComponentListener() {
        binding.btnActionPrivacy.setOnClickListener {
            when(binding.viewPagerPrivacy.currentItem) {
                CoreEnum.PrivacyViewType.VPN_CONFIGURATION_VIEW_TYPE.viewType -> {
                    binding.viewPagerPrivacy.setCurrentItem(CoreEnum.PrivacyViewType.PRIVACY_DETAILS_VIEW_TYPE.viewType, true)
                }

                CoreEnum.PrivacyViewType.PRIVACY_DETAILS_VIEW_TYPE.viewType -> {
                    binding.btnActionPrivacy.text = getString(R.string.privacy_activity_agree_continue_btn_title)
                }
            }
        }
    }
}
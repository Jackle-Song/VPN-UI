package com.mrsworkshop.vpnui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.adapter.PrivacyViewAdapter
import com.mrsworkshop.vpnui.core.CoreEnum
import com.mrsworkshop.vpnui.databinding.ActivityPrivacyBinding

class PrivacyActivity : AppCompatActivity(), PrivacyViewAdapter.PrivacyViewInterface {

    private lateinit var binding : ActivityPrivacyBinding
    private lateinit var privacyViewAdapter: PrivacyViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        setupComponentListener()
    }

    override fun proceedToNextView() {
        binding.viewPagerPrivacy.setCurrentItem(CoreEnum.PrivacyViewType.PRIVACY_DETAILS_VIEW_TYPE.viewType, true)
    }

    /**
     * private function
     */

    private fun initUI() {
        privacyViewAdapter = PrivacyViewAdapter(this@PrivacyActivity, this@PrivacyActivity)
        binding.viewPagerPrivacy.adapter = privacyViewAdapter
        binding.viewPagerPrivacy.isUserInputEnabled = false

        binding.viewPagerPrivacy.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                if (binding.viewPagerPrivacy.currentItem == CoreEnum.PrivacyViewType.PRIVACY_DETAILS_VIEW_TYPE.viewType) {
                    binding.btnActionPrivacy.text = getString(R.string.privacy_activity_agree_continue_btn_title)
                }
            }
        })
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
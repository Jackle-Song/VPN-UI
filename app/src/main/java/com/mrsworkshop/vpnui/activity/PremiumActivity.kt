package com.mrsworkshop.vpnui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.databinding.ActivityPremiumPlanBinding

class PremiumActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPremiumPlanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPremiumPlanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupComponentListener()
    }

    private fun setupComponentListener() {
        binding.imgClosePremium.setOnClickListener {
            finish()
        }

        binding.cardViewYearly.setOnClickListener {
            binding.cardViewYearly.strokeColor = ContextCompat.getColor(this, R.color.button_bg_49)
            binding.cardViewMonthly.strokeColor = ContextCompat.getColor(this, R.color.transparent)
            binding.cardViewWeekly.strokeColor = ContextCompat.getColor(this, R.color.transparent)
        }

        binding.cardViewMonthly.setOnClickListener {
            binding.cardViewMonthly.strokeColor = ContextCompat.getColor(this, R.color.button_bg_49)
            binding.cardViewYearly.strokeColor = ContextCompat.getColor(this, R.color.transparent)
            binding.cardViewWeekly.strokeColor = ContextCompat.getColor(this, R.color.transparent)
        }

        binding.cardViewWeekly.setOnClickListener {
            binding.cardViewWeekly.strokeColor = ContextCompat.getColor(this, R.color.button_bg_49)
            binding.cardViewMonthly.strokeColor = ContextCompat.getColor(this, R.color.transparent)
            binding.cardViewYearly.strokeColor = ContextCompat.getColor(this, R.color.transparent)
        }
    }
}
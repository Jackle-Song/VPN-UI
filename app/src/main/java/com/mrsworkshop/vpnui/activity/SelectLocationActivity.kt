package com.mrsworkshop.vpnui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.adapter.LocationOptionsAdapter
import com.mrsworkshop.vpnui.databinding.ActivitySelectLocationBinding
import com.mrsworkshop.vpnui.model.LocationOptionsVO

class SelectLocationActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectLocationBinding
    private lateinit var locationOptionsAdapter: LocationOptionsAdapter

    private var locationList : MutableList<LocationOptionsVO>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        setupComponentListener()
    }

    /**
     * private function
     */

    private fun initUI() {
        binding.layoutSelectLocationHeader.txtActivityTitle.text = getString(R.string.select_location_activity_title)
        initLocationList()

        binding.recyclerviewLocationList.layoutManager = LinearLayoutManager(this@SelectLocationActivity, LinearLayoutManager.VERTICAL, false)
        locationOptionsAdapter = LocationOptionsAdapter(this@SelectLocationActivity, locationList, locationList)
        binding.recyclerviewLocationList.adapter = locationOptionsAdapter
    }

    private fun initLocationList() {
        locationList?.add(LocationOptionsVO(R.drawable.ic_free_servers, "Free Servers", false))
        locationList?.add(LocationOptionsVO(R.drawable.ic_support_server, "Support Servers", false))
        locationList?.add(LocationOptionsVO(R.drawable.ic_fastest_server, "The Fastest Servers", true))
        locationList?.add(LocationOptionsVO(R.drawable.ic_singapore, "Singapore", true))
        locationList?.add(LocationOptionsVO(R.drawable.ic_uk, "United Kingdom", true))
        locationList?.add(LocationOptionsVO(R.drawable.ic_usa, "United States", true))
        locationList?.add(LocationOptionsVO(R.drawable.ic_india, "India", true))
        locationList?.add(LocationOptionsVO(R.drawable.ic_ml, "Mobile Legend", true))
        locationList?.add(LocationOptionsVO(R.drawable.ic_pubg, "PUBG", true))
        locationList?.add(LocationOptionsVO(R.drawable.ic_australia, "Australia", true))
        locationList?.add(LocationOptionsVO(R.drawable.ic_canada, "Canada", true))
        locationList?.add(LocationOptionsVO(R.drawable.ic_spain, "Spain", true))
        locationList?.add(LocationOptionsVO(R.drawable.ic_mexico, "Mexico", true))
    }

    private fun setupComponentListener() {
        binding.layoutSelectLocationHeader.imgBackBtn.setOnClickListener {
            finish()
        }

        binding.etSearchLocation.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                locationOptionsAdapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                // Not needed
            }
        })

        binding.etSearchLocation.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                // EditText is focused, change CardView stroke color
                binding.cardViewSearchLocation.strokeColor = ContextCompat.getColor(this, R.color.button_bg_49)
            } else {
                // EditText lost focus, change CardView stroke color back to the default
                binding.cardViewSearchLocation.strokeColor = (ContextCompat.getColor(this, R.color.light_grey_e1))
            }
        }
    }
}
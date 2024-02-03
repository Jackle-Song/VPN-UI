package com.mrsworkshop.vpnui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.adapter.LanguageOptionsAdapter
import com.mrsworkshop.vpnui.databinding.ActivityLanguageOptionBinding
import com.mrsworkshop.vpnui.model.LanguageOptionsVO

class LanguageOptionsActivity : AppCompatActivity(),
    LanguageOptionsAdapter.LanguageOptionInterface {
    private lateinit var binding: ActivityLanguageOptionBinding
    private lateinit var languageOptionsAdapter: LanguageOptionsAdapter

    private var languageList : MutableList<LanguageOptionsVO>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguageOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        setupComponentListener()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun selectLanguage(position: Int) {
        for (index in 0 until  (languageList?.size ?: 0)) {
            val languageItem = languageList?.get(index)
            languageItem?.isSelected = index == position
            languageOptionsAdapter.notifyDataSetChanged()
        }
    }

    /**
     * private function
     */

    private fun initUI() {
        binding.layoutLanguageHeader.txtActivityTitle.text = getString(R.string.language_activity_title)

        val languageOptions = resources.getStringArray(R.array.language_options).toMutableList()

        for (index in languageOptions.indices) {
            val language = languageOptions[index]
            if (index == 0) {
                languageList?.add(LanguageOptionsVO(language, true))
            }
            else {
                languageList?.add(LanguageOptionsVO(language, false))
            }
        }

        binding.recyclerviewLanguageOptions.layoutManager = LinearLayoutManager(this@LanguageOptionsActivity, LinearLayoutManager.VERTICAL, false)
        languageOptionsAdapter = LanguageOptionsAdapter(this@LanguageOptionsActivity, languageList, this@LanguageOptionsActivity)
        binding.recyclerviewLanguageOptions.adapter = languageOptionsAdapter
    }

    private fun setupComponentListener() {
        binding.layoutLanguageHeader.imgBackBtn.setOnClickListener {
            finish()
        }
    }
}
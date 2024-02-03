package com.mrsworkshop.vpnui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.model.LanguageOptionsVO

class LanguageOptionsAdapter (
    private val mContext : Context,
    private val languageList : MutableList<LanguageOptionsVO>?,
    private val mListener : LanguageOptionInterface,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface LanguageOptionInterface {
        fun selectLanguage(position: Int)
    }

    class LanguageOptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtLanguageOption : TextView = itemView.findViewById(R.id.txtLanguageOption)
        val imgSelectedOption : ImageView = itemView.findViewById(R.id.imgSelectedOption)
        val layoutLanguageOptions : LinearLayout = itemView.findViewById(R.id.layoutLanguageOptions)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_language_options, parent, false)
        return LanguageOptionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val languageItem = languageList?.get(position)
        val languageHolder = holder as LanguageOptionViewHolder

        if (!languageItem?.language.isNullOrEmpty()) {
            languageHolder.txtLanguageOption.text = languageItem?.language
        }

        if (languageItem?.isSelected == true) {
            languageHolder.imgSelectedOption.visibility = View.VISIBLE
            languageHolder.txtLanguageOption.setTextColor(ContextCompat.getColor(mContext, R.color.button_bg_18))
        }
        else {
            languageHolder.imgSelectedOption.visibility = View.INVISIBLE
            languageHolder.txtLanguageOption.setTextColor(ContextCompat.getColor(mContext, R.color.grey_49))
        }

        languageHolder.layoutLanguageOptions.setOnClickListener {
            mListener.selectLanguage(position)
        }
    }
}
package com.mrsworkshop.vpnui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.core.CoreEnum

class PrivacyViewAdapter(
    private val mContext : Context,
    private val mListener : PrivacyViewInterface,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface PrivacyViewInterface {
        fun proceedToNextView()
    }

    class VpnConfigurationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val closeBtn : ImageView = itemView.findViewById(R.id.imgCloseBtnPrivacy)
    }

    class PrivacyDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            CoreEnum.PrivacyViewType.VPN_CONFIGURATION_VIEW_TYPE.viewType -> {
                CoreEnum.PrivacyViewType.VPN_CONFIGURATION_VIEW_TYPE.viewType
            }

            CoreEnum.PrivacyViewType.PRIVACY_DETAILS_VIEW_TYPE.viewType -> {
                CoreEnum.PrivacyViewType.PRIVACY_DETAILS_VIEW_TYPE.viewType
            }

            else -> {
                CoreEnum.PrivacyViewType.VPN_CONFIGURATION_VIEW_TYPE.viewType
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View
        when (viewType) {
            CoreEnum.PrivacyViewType.VPN_CONFIGURATION_VIEW_TYPE.viewType -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.layout_privacy_setup_configuration, parent, false)
                return VpnConfigurationViewHolder(view)
            }

            CoreEnum.PrivacyViewType.PRIVACY_DETAILS_VIEW_TYPE.viewType -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.layout_privacy_details, parent, false)
                return PrivacyDetailsViewHolder(view)
            }

            else -> {
                view = LayoutInflater.from(parent.context).inflate(R.layout.layout_privacy_setup_configuration, parent, false)
                return VpnConfigurationViewHolder(view)
            }
        }
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            CoreEnum.PrivacyViewType.VPN_CONFIGURATION_VIEW_TYPE.viewType -> {
               val vpnViewHolder = holder as VpnConfigurationViewHolder

                vpnViewHolder.closeBtn.setOnClickListener {
                    mListener.proceedToNextView()
                }
            }

            CoreEnum.PrivacyViewType.PRIVACY_DETAILS_VIEW_TYPE.viewType -> {
                val  privacyViewHolder = holder as PrivacyDetailsViewHolder
            }
        }
    }
}
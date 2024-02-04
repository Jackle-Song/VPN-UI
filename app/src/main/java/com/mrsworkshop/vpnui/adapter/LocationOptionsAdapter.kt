package com.mrsworkshop.vpnui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mrsworkshop.vpnui.R
import com.mrsworkshop.vpnui.model.LocationOptionsVO

class LocationOptionsAdapter(
    private val mContext : Context,
    private val locationList : MutableList<LocationOptionsVO>?,
    private var filteredLocationList: MutableList<LocationOptionsVO>?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        filteredLocationList = locationList?.toMutableList()
    }

    class LocationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgLocationItem : ImageView = itemView.findViewById(R.id.imgLocationItem)
        val txtLocationItem : TextView = itemView.findViewById(R.id.txtLocationItem)
        val imgLockedLocation : ImageView = itemView.findViewById(R.id.imgLockedLocation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_select_location, parent, false)
        return LocationItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return filteredLocationList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val locationItem = filteredLocationList?.get(position)
        val locationHolder = holder as LocationItemViewHolder

        if (locationItem?.locationImage != null) {
            locationHolder.imgLocationItem.setImageResource(locationItem.locationImage ?: 0)
        }

        if (!locationItem?.locationName.isNullOrEmpty()) {
            locationHolder.txtLocationItem.text = locationItem?.locationName
        }

        if (locationItem?.isLocked == true) {
            locationHolder.imgLockedLocation.visibility = View.VISIBLE
        }
        else {
            locationHolder.imgLockedLocation.visibility = View.INVISIBLE
        }
    }

    fun filter(query: String) {
        filteredLocationList?.clear()

        if (query.isEmpty()) {
            filteredLocationList?.addAll(locationList ?: mutableListOf())
        } else {
            locationList?.let { originalList ->
                val filtered = originalList.filter { location ->
                    location.locationName?.contains(query, true) == true
                }
                filteredLocationList?.addAll(filtered)
            }
        }

        notifyDataSetChanged()
    }
}
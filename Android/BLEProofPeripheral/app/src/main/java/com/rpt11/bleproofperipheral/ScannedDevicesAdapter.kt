package com.rpt11.bleproofperipheral

import android.bluetooth.le.ScanResult
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ScannedDevicesAdapter(
    private var list: ArrayList<ScanResult>,
    val onClickListener: ScannedDevicesCallBack
) : RecyclerView.Adapter<ScannedDevicesAdapter.ViewHolder>() {

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.itemName.text = item.scanRecord?.deviceName ?: item.device.name
        holder.itemName.setOnClickListener { onClickListener.connectToDevice(item) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = inflater.inflate(
            R.layout.item_scanned_devices,
            parent,
            false
        )
        return ViewHolder(item)
    }

    fun update(updatedList: ArrayList<ScanResult>) {
        list = updatedList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.tv_name_field)
    }
}
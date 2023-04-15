package com.perihanimamoglu.satellites.ui.satellites.adapter

import androidx.recyclerview.widget.DiffUtil
import com.perihanimamoglu.satellites.domain.satellite.data.Satellite

class SatelliteDiffCallback : DiffUtil.ItemCallback<Satellite>() {
    override fun areItemsTheSame(oldItem: Satellite, newItem: Satellite): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Satellite, newItem: Satellite
    ): Boolean {
        return oldItem == newItem
    }
}
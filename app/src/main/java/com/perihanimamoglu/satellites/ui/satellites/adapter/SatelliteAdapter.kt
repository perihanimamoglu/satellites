package com.perihanimamoglu.satellites.ui.satellites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.perihanimamoglu.satellites.databinding.ItemSatelliteBinding
import com.perihanimamoglu.satellites.domain.satellite.data.Satellite
import javax.inject.Inject

class SatelliteAdapter @Inject constructor() :
    ListAdapter<Satellite, SatelliteViewHolder>(SatelliteDiffCallback()) {

    var onItemClickListener: ((Satellite) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SatelliteViewHolder {
        val binding =
            ItemSatelliteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SatelliteViewHolder(binding = binding, onItemClickListener = onItemClickListener)
    }

    override fun onBindViewHolder(holder: SatelliteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
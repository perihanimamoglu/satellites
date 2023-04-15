package com.perihanimamoglu.satellites.ui.satellites.adapter

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.perihanimamoglu.satellites.databinding.ItemSatelliteBinding
import com.perihanimamoglu.satellites.domain.satellite.data.Satellite

class SatelliteViewHolder(
    private val binding: ItemSatelliteBinding,
    private var onItemClickListener: ((Satellite) -> Unit)? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(satellite: Satellite) {
        val viewState = SatelliteViewState(satellite = satellite)
        binding.apply {
            textViewName.setTextColor(
                ContextCompat.getColor(
                    root.context, viewState.getTextColor()
                )
            )
            textViewActive.setTextColor(
                ContextCompat.getColor(
                    root.context, viewState.getTextColor()
                )
            )
            textViewName.text = viewState.getName()
            textViewActive.text = viewState.getActiveText(root.context)

            binding.imageView.background = ContextCompat.getDrawable(
                root.context, viewState.getImageViewActiveDrawable()
            )
            root.setOnClickListener {
                onItemClickListener?.invoke(satellite)
            }
        }
    }
}
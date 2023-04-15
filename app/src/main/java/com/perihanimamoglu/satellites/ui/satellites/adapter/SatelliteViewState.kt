package com.perihanimamoglu.satellites.ui.satellites.adapter

import android.content.Context
import com.perihanimamoglu.satellites.R
import com.perihanimamoglu.satellites.domain.satellite.data.Satellite

class SatelliteViewState(private val satellite: Satellite) {

    fun getName() = satellite.name

    private fun getActive() = satellite.active

    fun getImageViewActiveDrawable() = if (getActive()) {
        R.drawable.ic_circle_green
    } else {
        R.drawable.ic_circle_red
    }

    fun getActiveText(context: Context) = if (getActive()) {
        context.getString(R.string.active)
    } else {
        context.getString(R.string.passive)
    }

    fun getTextColor() = if (getActive()) {
        R.color.black
    } else {
        R.color.gray
    }
}
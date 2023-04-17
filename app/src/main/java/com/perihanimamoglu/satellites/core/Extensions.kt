package com.perihanimamoglu.satellites.core

import android.annotation.SuppressLint
import android.content.res.AssetManager
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

fun AssetManager.readFile(fileName: String) =
    this.open(fileName).bufferedReader().use { it.readText() }

fun Int?.orZero() = this ?: 0

fun Boolean?.orFalse() = this ?: false

fun Long?.orZero() = this ?: 0L

fun Double?.orZero() = this ?: 0.0

@SuppressLint("SimpleDateFormat")
fun String.convertToDate(): Date? {
    val dateFormat = SimpleDateFormat("yyyy-mm-dd")
    return dateFormat.parse(this)
}

@SuppressLint("SimpleDateFormat")
fun Date.convertToString(): String {
    val dateFormat = SimpleDateFormat("dd.mm.yyyy")
    return dateFormat.format(this)
}
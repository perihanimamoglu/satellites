package com.perihanimamoglu.satellites.core

import android.content.res.AssetManager

fun AssetManager.readFile(fileName: String) =
    this.open(fileName).bufferedReader().use { it.readText() }

fun Int?.orZero() = this ?: 0

fun Boolean?.orFalse() = this ?: false

fun Long?.orZero() = this ?: 0L
package com.perihanimamoglu.satellites.core

sealed class ViewState<out T> {

    object Loading : ViewState<Nothing>()

    class Success<T>(val data: T) : ViewState<T>()

    data class Error(val exception: Throwable) : ViewState<Nothing>()
}
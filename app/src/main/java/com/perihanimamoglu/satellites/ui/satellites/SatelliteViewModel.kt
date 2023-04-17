package com.perihanimamoglu.satellites.ui.satellites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perihanimamoglu.satellites.core.ViewState
import com.perihanimamoglu.satellites.domain.satellite.SatelliteUseCase
import com.perihanimamoglu.satellites.domain.satellite.data.Satellite
import com.perihanimamoglu.satellites.domain.satelliteDetail.SatelliteDetailUseCase
import com.perihanimamoglu.satellites.domain.satelliteDetail.data.SatelliteDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteViewModel
@Inject constructor(
    private val satellitesUseCase: SatelliteUseCase,
    private val satelliteDetailUseCase: SatelliteDetailUseCase
) : ViewModel() {

    private val _satellites = MutableStateFlow<ViewState<List<Satellite>>>(ViewState.Loading)
    val satellites: StateFlow<ViewState<List<Satellite>>> = _satellites.asStateFlow()

    private val _satelliteDetail = MutableStateFlow<ViewState<SatelliteDetail>>(ViewState.Loading)
    val satelliteDetail: StateFlow<ViewState<SatelliteDetail>> = _satelliteDetail.asStateFlow()

    fun fetchSatellites() {
        viewModelScope.launch {
            satellitesUseCase.fetchSatellites()
                .catch { e -> _satellites.value = ViewState.Error(e) }
                .collect { satellites -> _satellites.value = ViewState.Success(satellites) }
        }
    }

    fun fetchLocalSatelliteDetail(satellite: Satellite) {
        viewModelScope.launch {
            satelliteDetailUseCase.fetchLocalSatelliteDetail(item = satellite)
                .catch { e -> _satelliteDetail.value = ViewState.Error(e) }.collect {
                    if (it == null) {
                        fetchSatelliteDetail(satellite)
                    } else {
                        _satelliteDetail.value = ViewState.Success(it)
                    }
                }
        }
    }

    fun fetchSatelliteDetail(satellite: Satellite) {
        viewModelScope.launch {
            satelliteDetailUseCase.fetchSatelliteDetail(item = satellite)
                .catch { e -> _satelliteDetail.value = ViewState.Error(e) }.collect {
                    _satelliteDetail.value = ViewState.Success(it)
                }
        }
    }

    fun setSatelliteDetailLoadingState() {
        _satelliteDetail.value = ViewState.Loading
    }

    fun filter(searchText: String): List<Satellite> {
        val satelliteList = (_satellites.value as ViewState.Success).data
        return if (searchText.length > 2) {
            val filterList = satelliteList.filter {
                it.name.length >= searchText.length && it.name.subSequence(0, searchText.length)
                    .contains(searchText, ignoreCase = true)
            }
            filterList
        } else {
            satelliteList
        }
    }
}
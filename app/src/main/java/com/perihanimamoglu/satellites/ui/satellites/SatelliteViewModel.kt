package com.perihanimamoglu.satellites.ui.satellites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perihanimamoglu.satellites.domain.satellite.SatelliteUseCase
import com.perihanimamoglu.satellites.domain.satellite.data.Satellite
import com.perihanimamoglu.satellites.domain.satelliteDetail.SatelliteDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteViewModel
@Inject constructor(
    private val satellitesUseCase: SatelliteUseCase
) : ViewModel() {

    private val _satellites = MutableStateFlow<List<Satellite>>(listOf())
    val satellites: StateFlow<List<Satellite>> = _satellites.asStateFlow()

    fun fetchSatellites() {
        viewModelScope.launch {
            satellitesUseCase.fetchSatellites().collect { satellites ->
                _satellites.value = satellites
            }
        }
    }
}
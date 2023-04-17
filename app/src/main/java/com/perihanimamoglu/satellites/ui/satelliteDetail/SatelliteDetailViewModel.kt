package com.perihanimamoglu.satellites.ui.satelliteDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.perihanimamoglu.satellites.domain.satellitePositions.SatellitePositionsUseCaseImpl
import com.perihanimamoglu.satellites.domain.satellitePositions.data.SatellitePosition
import com.perihanimamoglu.satellites.domain.satellitePositions.data.SatellitePositionDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SatelliteDetailViewModel
@Inject constructor(
    private val satellitePositionsUseCaseImpl: SatellitePositionsUseCaseImpl
) : ViewModel() {

    private val _satellitePositionDetail = MutableStateFlow<SatellitePositionDetail?>(null)
    val satellitePositionDetail: StateFlow<SatellitePositionDetail?> =
        _satellitePositionDetail.asStateFlow()

    fun fetchSatellitePositions(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            satellitePositionsUseCaseImpl.fetchSatellitePositions(id).collect {
                fetchSatellitePosition(it.list, id)
            }
        }
    }

    private fun fetchSatellitePosition(satellitePositions: List<SatellitePosition>, id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            satellitePositionsUseCaseImpl.fetchSatellitePosition(satellitePositions, id)
                .collect { item ->
                    _satellitePositionDetail.value = item
                }
        }
    }
}
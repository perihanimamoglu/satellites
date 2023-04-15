package com.perihanimamoglu.satellites.ui.satellites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.perihanimamoglu.satellites.databinding.FragmentSatellitesBinding
import com.perihanimamoglu.satellites.ui.satellites.adapter.SatelliteAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SatelliteFragment : Fragment() {

    private var _binding: FragmentSatellitesBinding? = null
    private val binding get() = _binding!!

    private val satelliteViewModel: SatelliteViewModel by viewModels()

    private var satelliteAdapter: SatelliteAdapter = SatelliteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSatellitesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        satelliteViewModel.fetchSatellites()
        binding.recyclerView.adapter = satelliteAdapter
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            launch {
                satelliteViewModel.satellites.collect {
                    satelliteAdapter.submitList(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = SatelliteFragment()
    }
}
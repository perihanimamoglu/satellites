package com.perihanimamoglu.satellites.ui.satellites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.perihanimamoglu.satellites.core.ViewState
import com.perihanimamoglu.satellites.databinding.FragmentSatellitesBinding
import com.perihanimamoglu.satellites.domain.satelliteDetail.data.SatelliteDetail
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
        initOnClickListeners()
        initObservers()
        satelliteViewModel.fetchSatellites()
        binding.recyclerView.adapter = satelliteAdapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this.context, DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            launch {
                satelliteViewModel.satellites.collect { viewState ->
                    when (viewState) {
                        is ViewState.Success -> {
                            binding.apply {
                                progressBar.visibility = View.GONE
                                textViewErrorMessage.visibility = View.GONE
                            }
                            satelliteAdapter.submitList(viewState.data)
                        }
                        is ViewState.Loading -> {
                            binding.apply {
                                progressBar.visibility = View.VISIBLE
                                textViewErrorMessage.visibility = View.GONE
                            }
                        }
                        else -> {
                            binding.apply {
                                progressBar.visibility = View.GONE
                                searchView.visibility = View.GONE
                                textViewErrorMessage.visibility = View.VISIBLE
                            }
                        }
                    }
                }
            }
            launch {
                satelliteViewModel.satelliteDetail.collect { viewState ->
                    when (viewState) {
                        is ViewState.Success -> {
                            binding.apply {
                                progressBar.visibility = View.GONE
                                textViewErrorMessage.visibility = View.GONE
                            }
                            navigateToSatelliteDetail(viewState.data)
                        }
                        is ViewState.Loading -> {
                            binding.apply {
                                progressBar.visibility = View.VISIBLE
                                textViewErrorMessage.visibility = View.GONE
                            }
                        }
                        else -> {
                            binding.apply {
                                progressBar.visibility = View.GONE
                                searchView.visibility = View.GONE
                                textViewErrorMessage.visibility = View.VISIBLE
                            }
                        }
                    }
                }
            }
        }
    }

    private fun navigateToSatelliteDetail(satelliteDetail: SatelliteDetail) {
        val action = SatelliteFragmentDirections.actionSatelliteFragmentToSatelliteDetailFragment(
            satelliteDetail = satelliteDetail
        )
        view?.findNavController()?.navigate(action)
        satelliteViewModel.setSatelliteDetailLoadingState()
    }

    private fun initOnClickListeners() {
        satelliteAdapter.onItemClickListener = { satellite ->
            satelliteViewModel.fetchLocalSatelliteDetail(satellite)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                val filterList = satelliteViewModel.filter(newText.trim())
                satelliteAdapter.submitList(filterList)
                return true
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
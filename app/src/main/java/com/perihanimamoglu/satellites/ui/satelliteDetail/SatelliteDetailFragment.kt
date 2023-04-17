package com.perihanimamoglu.satellites.ui.satelliteDetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.perihanimamoglu.satellites.databinding.FragmentSatelliteDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SatelliteDetailFragment : Fragment() {

    private var _binding: FragmentSatelliteDetailBinding? = null
    private val binding get() = _binding!!

    private val args: SatelliteDetailFragmentArgs by navArgs()

    private val satelliteDetailViewModel: SatelliteDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSatelliteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        val viewState = SatelliteDetailViewState(satelliteDetail = args.satelliteDetail)
        binding.apply {
            textViewName.text = viewState.getName()
            textViewFirstFlight.text = viewState.getFirstFlight()
            textViewHeightMass.text = viewState.getHeightMass()
            textViewCost.text = viewState.getCost()
        }
        satelliteDetailViewModel.fetchSatellitePositions(viewState.getId())
    }

    @SuppressLint("SetTextI18n")
    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            launch {
                satelliteDetailViewModel.satellitePositionDetail.collect {
                    binding.textViewLastPosition.text =
                        SpannableStringBuilder().bold { append("Last Position: ") }
                            .append("(" + it?.posX + "," + it?.posY + ")")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
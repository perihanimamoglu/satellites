package com.perihanimamoglu.satellites.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.perihanimamoglu.satellites.R
import com.perihanimamoglu.satellites.databinding.ActivityMainBinding
import com.perihanimamoglu.satellites.ui.satellites.SatelliteFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            add<SatelliteFragment>(R.id.frameLayout)
        }
    }
}
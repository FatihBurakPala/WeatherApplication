package com.android.weatherapplication.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.weatherapplication.common.viewBinding
import com.android.weatherapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}

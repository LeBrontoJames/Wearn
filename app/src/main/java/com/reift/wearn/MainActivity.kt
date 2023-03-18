package com.reift.wearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.reift.wearn.adapter.WearnAdapter
import com.reift.wearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.adapter = WearnAdapter(this)
    }
}
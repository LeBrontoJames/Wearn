package com.reift.wearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.reift.wearn.adapter.SubjectAdapter
import com.reift.wearn.databinding.ActivitySubjectBinding

class SubjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWatchToLearn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        setUpSubjectRv()
    }

    private fun setUpSubjectRv() {
        binding.rvSubject.apply {
            adapter = SubjectAdapter()
            layoutManager = StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL)
        }
    }
}
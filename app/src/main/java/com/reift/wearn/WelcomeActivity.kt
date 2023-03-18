package com.reift.wearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        findViewById<MaterialButton>(R.id.btn_start_learning).setOnClickListener {
            startActivity(
                Intent(this, SubjectActivity::class.java)
            )
        }
    }
}
package com.example.learningapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val btnAbout: Button = findViewById(R.id.btnAbout)

        btnAbout.setOnClickListener {
            var pindah12 = Intent(this, MainActivity::class.java)
            startActivity(pindah12)
        }

    }

}
package com.example.learningapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cvData: CardView = findViewById(R.id.cv_listData)
        val cvAdd: CardView = findViewById(R.id.cv_addData)
        val cvAbout: CardView = findViewById(R.id.cv_about)
        val cvLogout: CardView = findViewById(R.id.cv_logout)

        val savedLogin = getSharedPreferences("Login", MODE_PRIVATE)
        val editSavedLogin = savedLogin.edit()

        cvData.setOnClickListener {
            var pindah1 = Intent(this, RvDbActivity::class.java)
            startActivity(pindah1)
        }
        cvAdd.setOnClickListener {
            var pindah2 = Intent(this, TodoaddActivity::class.java)
            startActivity(pindah2)
        }
        cvAbout.setOnClickListener {
            var pindah3 = Intent(this, AboutActivity::class.java)
            startActivity(pindah3)
        }

        cvLogout.setOnClickListener {
            editSavedLogin.putString("Email", null)
            editSavedLogin.putString("Password", null)
            editSavedLogin.putString("Status", "Off")
            editSavedLogin.commit()
            startActivity(Intent(this, LoginActivity::class.java))
        }



    }
}
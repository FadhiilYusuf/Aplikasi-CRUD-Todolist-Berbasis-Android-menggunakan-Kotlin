package com.example.learningapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class ExampleActivity : AppCompatActivity() {
    lateinit var userDBHelper: DBHelper

    lateinit var tampil: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        userDBHelper = DBHelper(this)
        tampil = findViewById(R.id.tampilsemua)
        var tampilkan = userDBHelper.fullDataUser()
        tampilkan.forEach {
            tampil.text = tampil.text.toString() + " " + it.email.toString() + " - "  + it.pass.toString() + " - "  +
                    it.fullname.toString() + " - "  + it.jeniskelamin.toString() + "\n"
        }

    }
}
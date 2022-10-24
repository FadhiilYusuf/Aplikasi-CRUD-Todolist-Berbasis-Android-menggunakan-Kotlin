package com.example.learningapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class TodoActivity : AppCompatActivity() {

    lateinit var todoDBHelper2: DBHelper2
    lateinit var tampil: TextView
    lateinit var lltampil: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        todoDBHelper2 = DBHelper2(this)
        tampil = findViewById(R.id.tampil_semua)
        lltampil = findViewById(R.id.ll_tampil)

        var tampilkan = todoDBHelper2.fullData()

        tampilkan.forEach {
            tampil.text = tampil.text.toString() + " " + it.judul.toString() + " - "  + it.tanggal.toString() + " - "  +
                    it.keterangan.toString() + "\n"
           // lltampil.addView(tampil)
        }

    }
}
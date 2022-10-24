package com.example.learningapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class TodoaddActivity : AppCompatActivity() {

    lateinit var todoDBHelper2: DBHelper2
    lateinit var inputJudul: EditText
    lateinit var inputTanggal: EditText
    lateinit var inputKeterangan: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todoadd)

        inputJudul = findViewById(R.id.input_judul)
        inputTanggal = findViewById(R.id.input_tanggal)
        inputKeterangan = findViewById(R.id.input_keterangan)
        todoDBHelper2 = DBHelper2(this)

    }
    fun addData(v: View){
        var judulin = inputJudul.text.toString()
        var tanggalin = inputTanggal.text.toString()
        var keteranganin = inputKeterangan.text.toString()
        todoDBHelper2.insertData(judulin, tanggalin, keteranganin)
        inputJudul.setText("")
        inputTanggal.setText("")
        inputKeterangan.setText("")
        val toast: Toast = Toast.makeText(applicationContext,
            "Berhasil Menambahkan Data", Toast.LENGTH_SHORT)
        toast.show()
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }
    /*
    fun showAll(v: View){
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }
    */


}
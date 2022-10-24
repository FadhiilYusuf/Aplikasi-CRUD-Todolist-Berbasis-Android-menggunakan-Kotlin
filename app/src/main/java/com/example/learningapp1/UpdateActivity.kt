package com.example.learningapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class UpdateActivity : AppCompatActivity() {

    lateinit var todoDBHelper2: DBHelper2
    lateinit var inputJudul: EditText
    lateinit var inputTanggal: EditText
    lateinit var inputKeterangan: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        inputJudul = findViewById(R.id.input_judulu)
        inputTanggal = findViewById(R.id.input_tanggalu)
        inputKeterangan = findViewById(R.id.input_keteranganu)
        todoDBHelper2 = DBHelper2(this)

        val bundle = intent.extras
        if (bundle!=null){
            inputJudul.setText(bundle.getString("judulk"))
            inputTanggal.setText(bundle.getString("tanggalk"))
            inputKeterangan.setText(bundle.getString("keterangank"))
        }
    }

    fun updateData(v: View){
        var judulin = inputJudul.text.toString()
        var tanggalin = inputTanggal.text.toString()
        var keteranganin = inputKeterangan.text.toString()

        todoDBHelper2.updateData(judulin, tanggalin, keteranganin)

        val toast: Toast = Toast.makeText(applicationContext,
            "Berhasil Update Data", Toast.LENGTH_SHORT)
        toast.show()

        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }

    fun cancelData(v: View){
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }

}
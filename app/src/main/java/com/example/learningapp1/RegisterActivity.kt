package com.example.learningapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    lateinit var eemail: EditText
    lateinit var epassword: EditText
    lateinit var efullname: EditText
    lateinit var ejenkal: EditText
    lateinit var ealamat: EditText
    lateinit var btnregister: Button
    lateinit var btncancel: Button
    lateinit var userDBHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        eemail = findViewById(R.id.EditEmailRegister)
        epassword = findViewById(R.id.EditPasswordRegister)
        efullname= findViewById(R.id.EditFullnameRegister)
        ejenkal = findViewById(R.id.EditJenkalRegister)
        ealamat = findViewById(R.id.EditAlamatRegister)
        btnregister = findViewById(R.id.btnsubmitregister)
        btncancel = findViewById(R.id.btncancelregister)
        userDBHelper = DBHelper(this)

    }
    fun registerme(view: View){
        var iemail = eemail.text.toString()
        var ipassword = epassword.text.toString()
        var ifullname = efullname.text.toString()
        var ijenkal = ejenkal.text.toString()
        var ialamat = ealamat.text.toString()
        var cekuser = userDBHelper.cekUser(iemail)
        var status = "Gagal Register"
        if (cekuser =="0") {
            userDBHelper.RegisterUser(iemail, ipassword, ifullname, ijenkal, ialamat)
            status = "Sukses"
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
        val toast: Toast = Toast.makeText(applicationContext,
            status, Toast.LENGTH_SHORT)
        toast.show()
    }
    fun cancelme(view: View){
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
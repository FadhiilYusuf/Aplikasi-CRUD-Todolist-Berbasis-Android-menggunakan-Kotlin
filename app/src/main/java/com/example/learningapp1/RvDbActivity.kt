package com.example.learningapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RvDbActivity : AppCompatActivity() {

    private lateinit var rv_tampilanku: RecyclerView
    lateinit var todoDBHelper2: DBHelper2
    private  var list: ArrayList<DBModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_db)

        rv_tampilanku = findViewById(R.id.rv_tampilkan)
        rv_tampilanku.setHasFixedSize(true)
        todoDBHelper2 = DBHelper2(this)
        list.addAll(todoDBHelper2.fullData())
        rv_tampilanku.layoutManager = LinearLayoutManager(this)
        var cardData = DBAdapter(list)
        rv_tampilanku.adapter = cardData

    }

    //menu
/*
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_about  -> {
                var pindah3 = Intent(this, AboutActivity::class.java)
                startActivity(pindah3)
            }
            R.id.action_home -> {
                val moveIntent = Intent(this, MainActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.action_logout -> {
            }
        }
    }
*/


}
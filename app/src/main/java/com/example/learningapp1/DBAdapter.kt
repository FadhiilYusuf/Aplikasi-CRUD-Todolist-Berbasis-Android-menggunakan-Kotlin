package com.example.learningapp1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DBAdapter(private val listDataku: ArrayList<DBModel>): RecyclerView.Adapter<DBAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemV: View): RecyclerView.ViewHolder(itemV) {
        var tvjudulku: TextView = itemV.findViewById(R.id.tv_judulku)
        var tvtanggalku: TextView = itemV.findViewById(R.id.tv_tanggalku)
        var tvketeranganku: TextView = itemV.findViewById(R.id.tv_keteranganku)
        var btndelete: Button = itemV.findViewById(R.id.btn_deletecard)
        var btnupdate: Button = itemV.findViewById(R.id.btn_updatecard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_dataku, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvjudulku.text = dataku.judul
        holder.tvtanggalku.text = dataku.tanggal
        holder.tvketeranganku.text = dataku.keterangan

        holder.btndelete.setOnClickListener {
            var adapterDBHelper: DBHelper2
            adapterDBHelper = DBHelper2(holder.itemView.context)
            adapterDBHelper.deleteData(dataku.judul)
            listDataku.removeAt(position)
            notifyDataSetChanged()
        }

        holder.btnupdate.setOnClickListener {
            val pindahUpdAc = Intent(holder.itemView.context, UpdateActivity::class.java)
            val bundle = Bundle()
            bundle.putString("judulk", dataku.judul)
            bundle.putString("tanggalk", dataku.tanggal)
            bundle.putString("keterangank", dataku.keterangan)

            pindahUpdAc.putExtras(bundle)
            holder.itemView.context.startActivity(pindahUpdAc)
        }

    }

    override fun getItemCount(): Int {
        return listDataku.size
    }

}
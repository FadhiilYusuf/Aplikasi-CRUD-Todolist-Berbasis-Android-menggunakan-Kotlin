package com.example.learningapp1

import android.provider.BaseColumns

object DBInfo2 {
    class UserInput: BaseColumns {
        companion object {
            val TABLE_NAME = "todo"
            val COL_JUDUL = "judul"
            val COL_TANGGAL = "tanggal"
            val COL_KETERANGAN = "keterangan"
        }
    }
}
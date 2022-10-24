package com.example.learningapp1

import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper2(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        val DATABASE_NAME = "todo.db"
        val DATABASE_VERSION = 1
        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBInfo2.UserInput.TABLE_NAME + " (" + DBInfo2.UserInput.COL_JUDUL +
                    " VARCHAR(200) PRIMARY KEY, " + DBInfo2.UserInput.COL_TANGGAL + " TEXT, " +
                    DBInfo2.UserInput.COL_KETERANGAN + " VARCHAR(200))"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBInfo2.UserInput.TABLE_NAME

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertData(judulin: String, tanggalin: String, keteranganin: String): Boolean {
        val db = writableDatabase
        val namatablet = DBInfo2.UserInput.TABLE_NAME
        val judult = DBInfo2.UserInput.COL_JUDUL
        val tanggalt = DBInfo2.UserInput.COL_TANGGAL
        val keterangant = DBInfo2.UserInput.COL_KETERANGAN
        var sql = "INSERT INTO "+ namatablet +"("+judult+", "+tanggalt+", "+keterangant+") " +
                "VALUES('"+judulin+"', '"+tanggalin+"', '"+keteranganin+"')"
        db.execSQL(sql)
        return true
    }

    fun fullData():ArrayList<DBModel>{
//        val todo = ArrayList<DBModel>()
        val todo = arrayListOf<DBModel>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("SELECT * FROM "+DBInfo2.UserInput.TABLE_NAME, null)
        }catch (e: SQLException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var judult: String
        var tanggalt: String
        var keterangat: String

        if (cursor!!.moveToFirst()){
            while (cursor.isAfterLast==false){
                judult = cursor.getString(cursor.getColumnIndex(DBInfo2.UserInput.COL_JUDUL))
                tanggalt = cursor.getString(cursor.getColumnIndex(DBInfo2.UserInput.COL_TANGGAL))
                keterangat = cursor.getString(cursor.getColumnIndex(DBInfo2.UserInput.COL_KETERANGAN))

                todo.add(DBModel(judult, tanggalt, keterangat))
                cursor.moveToNext()
            }
        }
        return todo
    }

    fun deleteData(judulin: String){
        val db = writableDatabase
        val namatablet = DBInfo2.UserInput.TABLE_NAME
        val judult = DBInfo2.UserInput.COL_JUDUL
        val sql = "DELETE FROM " +namatablet+ " WHERE "+judult+"='"+judulin+"'"
        db.execSQL(sql)
    }

    fun updateData(judulin: String, tanggalin: String, keteranganin: String){
        val db = writableDatabase
        val namatablet = DBInfo2.UserInput.TABLE_NAME
        val judult = DBInfo2.UserInput.COL_JUDUL
        val tanggalt = DBInfo2.UserInput.COL_TANGGAL
        val keterangant = DBInfo2.UserInput.COL_KETERANGAN
        var sql = "UPDATE "+ namatablet + " SET "+
                tanggalt+"='"+tanggalin+"', "+keterangant+"='"+keteranganin+"' "+
                "WHERE "+judult+"='"+judulin+"'"
        db.execSQL(sql)
    }


}

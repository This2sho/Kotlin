package twinparadox.memoapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.widget.Toast

class DBManager {
    val dbName="MyMemos"
    val dbTable="Memos"
    val colID="ID"
    val colTitle="Title"
    val colContent="Content"
    val dbVersion=1

    // "CREATE TABLE IF NOT EXISTS MyMemos (ID INTEGER PRIMARY KEY,title TEXT,Content TEXT);"
    val sqlCreateTable="CREATE TABLE IF NOT EXISTS "+dbTable+" ("+
            colID+" INTEGER PRIMARY KEY,"+
            colTitle+" TEXT, "+
            colContent+" TEXT);"
    var sqlDB:SQLiteDatabase?=null



    constructor(context:Context) {
        val db=DatabaseHelperMemos(context)
        sqlDB=db.writableDatabase
    }

    inner class DatabaseHelperMemos:SQLiteOpenHelper {
        var context:Context?=null

        constructor(context: Context):super(context,dbName,null,dbVersion) {
            this.context=context
        }

        override fun onCreate(sdb: SQLiteDatabase?) {
            sdb!!.execSQL(sqlCreateTable)
            Toast.makeText(this.context,"DB is created",Toast.LENGTH_LONG).show()
        }

        override fun onUpgrade(sdb: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            sdb!!.execSQL("Drop table IF EXISTS "+dbTable)
        }
    }

    fun Insert(values:ContentValues):Long {
        val ID=sqlDB!!.insert(dbTable,"",values)
        return ID
    }

    fun Query(projection: Array<String>, selection:String, selectionArgs:Array<String>, sorOrder:String): Cursor {
        val builder=SQLiteQueryBuilder()
        builder.tables=dbTable

        val cursor=builder.query(sqlDB,projection,selection, selectionArgs,null,null,sorOrder)
        return cursor
    }
}
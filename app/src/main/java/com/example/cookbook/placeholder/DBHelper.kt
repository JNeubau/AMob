package com.example.cookbook.placeholder

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE $TABLE_NAME ( $ID_COL INTEGER PRIMARY KEY, " +
                "$NAME_COL TEXT, $RECIPE_COL TEXT )")
        db.execSQL(query)
        addAll()
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        val query = "DROP TABLE IF EXISTS $TABLE_NAME"
        db.execSQL(query)
        onCreate(db)
    }

    private fun addAll() {
        val file: File = File(DATA_FILE)
        try {
            BufferedReader(FileReader(file)).use { br ->
                var line: String?
                while (br.readLine().also { line = it } != null) {
                    println(line)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun addNew(name: String, recipe: String, time: Int) {
        val values: ContentValues = ContentValues()
        values.put(NAME_COL, name)
        values.put(RECIPE_COL, recipe)
        values.put(TIME_COL, time)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    companion object {
        private const val DATABASE_NAME = "CookBook"
        private const val DATABASE_VERSION = 1

        val TABLE_NAME = "Recipes"
        val ID_COL = "id"
        val NAME_COL = "dish"
        val RECIPE_COL = "recipe"
        val TIME_COL = "timer"

        private const val DATA_FILE = "C:\\Users\\neuba\\Downloads\\Cookbook\\Cookbook\\app\\src\\main\\RecipeData.txt"
    }
}
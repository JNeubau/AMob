package com.example.cookbook

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast

class ActionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)
        val toolbar: Toolbar = findViewById<Toolbar>(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun onClickDone(view: View) {
        val text: CharSequence = "To jest prosty pasek snackbar."
        val duration = Snackbar.LENGTH_LONG
        val snackbar = Snackbar.make(findViewById<View>(R.id.coordinator), text, duration)
        snackbar.setAction("Cofnij") {
            val toast = Toast.makeText(applicationContext, "Cofnięto!", Toast.LENGTH_SHORT)
            toast.show()
        }
        snackbar.show()
    }

}

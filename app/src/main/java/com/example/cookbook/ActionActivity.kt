package com.example.cookbook

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
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
        val fm: FragmentManager = supportFragmentManager
        var fragment: Fragment? = fm.findFragmentById(R.id.fragment_sunset)
        if (fragment == null) {
            fragment = SunsetFragment.newInstance()
            fm.beginTransaction()
                .add(R.id.fragment_sunset, fragment)
                .commit()
        }
    }
}

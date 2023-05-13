package com.example.cookbook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.support.v4.app.FragmentTransaction
import com.example.cookbook.placeholder.DBHelper

class MainActivity : AppCompatActivity(), DishListFragment.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val db = DBHelper(this, null)
    }

    override fun itemClicked(id: Long) {
        val fragmentContainer = findViewById<View>(R.id.fragment_container)
        if (fragmentContainer != null) {
            val ft = supportFragmentManager.beginTransaction()
            val details = CookDetailFragment()
            details.setDish(id)
            ft.replace(R.id.fragment_container, details)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.addToBackStack(null)
            ft.commit()
        } else {
            val intent: Intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_RECIPE_ID, id)
            startActivity(intent)
        }
    }
}
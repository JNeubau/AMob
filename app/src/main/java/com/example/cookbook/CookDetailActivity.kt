package com.example.cookbook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.ContextCompat
import android.support.v4.view.MenuItemCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.ShareActionProvider
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class CookDetailActivity : AppCompatActivity() {
    private var time: Int = 0

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_cook_detail)
//        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
//        setSupportActionBar(toolbar)
//        val actionBar = supportActionBar
//        actionBar!!.setDisplayHomeAsUpEnabled(true)
//
//        val cookId = intent.extras!![EXTRA_COOK_ID] as Int
//        val dish: Dish = Dish.dishes[cookId.toInt()]
//        val dishName = dish.name
//        val textView = findViewById<View>(R.id.textTitle) as TextView
//        textView.text = dishName
//        val dishImage: Int = dish.imageResourceId
//        val imageView = findViewById<View>(R.id.dish_image) as ImageView
//        imageView.setImageDrawable(ContextCompat.getDrawable(this, dishImage))
//        imageView.contentDescription = dish.name
////        val dishRecipe = dish.recipe
////        val textViewRecipe = findViewById<View>(R.id.textDescription) as TextView
////        textViewRecipe.text = dishRecipe
//    }

    private var shareActionProvider: ShareActionProvider? = null
    private var dishId: Long = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cook_detail)
        val toolbar: Toolbar = findViewById<Toolbar>(R.id.toolbar_detail)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val cookId = intent.extras!![EXTRA_COOK_ID] as Int
        val dish: Dish = Dish.dishes[cookId.toInt()]
        val dishName = dish.name
        val textView = findViewById<View>(R.id.textTitle) as TextView
        textView.text = dishName
        val dishImage: Int = dish.imageResourceId
        val imageView = findViewById<View>(R.id.dish_image) as ImageView
        imageView.setImageDrawable(ContextCompat.getDrawable(this, dishImage))
        imageView.contentDescription = dish.name

        if (savedInstanceState == null) {
            val timer = TimerFragment()
            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.fragment_timer_in_activity, timer)
            ft.addToBackStack(null)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.commit()

            time = Dish.dishes[cookId.toInt()].time
            val args = Bundle()
            args.putInt("time", time)
            timer.arguments = args
        } else {
            dishId = savedInstanceState.getLong("dishId")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem: MenuItem = menu.findItem(R.id.action_share)
        shareActionProvider = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
        setShareActionIntent("Blalala")
        return super.onCreateOptionsMenu(menu)
    }

    private fun setShareActionIntent(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        shareActionProvider!!.setShareIntent(intent)
    }

    fun onClickDone(view: View) {
        val text: CharSequence = "To jest prosty pasek snackbar."
        val duration = Snackbar.LENGTH_SHORT
        val snackbar = Snackbar.make(findViewById<View>(R.id.coordinator), text, duration)
        snackbar.setAction("Cofnij") {
            val toast = Toast.makeText(applicationContext, "Cofnięto!", Toast.LENGTH_SHORT)
            toast.show()
        }
        snackbar.show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_action -> {
                // Kod wykonywany po kliknięciu elementu Action_Activity
                val intent = Intent(this, ActionActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



    companion object {
        val EXTRA_COOK_ID = "dishId"
    }
}
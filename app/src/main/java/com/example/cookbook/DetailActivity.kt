package com.example.cookbook

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.ShareActionProvider
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout

class DetailActivity : AppCompatActivity() {

    private var time: Int = 0
    private var shareActionProvider: ShareActionProvider? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolbar: Toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val frag: CookDetailFragment = supportFragmentManager.findFragmentById(R.id.detail_frag) as CookDetailFragment
        val dishId = intent.extras!![EXTRA_RECIPE_ID] as Long
//        val dishId: Long = getIntent().getExtras()?.getString(EXTRA_RECIPE_ID) as Long
        frag!!.setDish(dishId)

        val clock = findViewById<FrameLayout>(R.id.timer_container)
        clock.visibility = FrameLayout.GONE

        val clock2 = findViewById<FrameLayout>(R.id.timer_container2)
        clock2.visibility = FrameLayout.VISIBLE

        if (savedInstanceState == null) {
            val timer = TimerFragment()
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.timer_container2, timer)
            ft.commit()

            time = Dish.dishes[dishId.toInt()].time
            val args = Bundle()
            args.putInt("time", time)
            timer.arguments = args
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem: MenuItem = menu.findItem(R.id.action_share)
        shareActionProvider = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
        setShareActionIntent("Blalala")
        return super.onCreateOptionsMenu(menu)
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

    private fun setShareActionIntent(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        shareActionProvider!!.setShareIntent(intent)
    }

    companion object {
        const val EXTRA_RECIPE_ID: String = "id"
    }
}
package com.example.cookbook

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.MenuItemCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.ShareActionProvider
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity(), DishListFragment.Listener {

    private var shareActionProvider: ShareActionProvider? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById<Toolbar>(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        val pagerAdapter: SectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val pager: ViewPager = findViewById<ViewPager>(R.id.pager)
        pager.adapter = pagerAdapter
        val tabLayout: TabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(pager)
//        val db = DBHelper(this, null)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem: MenuItem = menu.findItem(R.id.action_share)
        shareActionProvider = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
        setShareActionIntent("Blalala")
        return super.onCreateOptionsMenu(menu)
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
}

private class SectionsPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return TopFragment()
            1 -> return Tab1Fragment()
            2 -> return Tab2Fragment()
        }
        return null
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Lista Dań"
            1 -> return "kategoria 1"
            2 -> return "kategoria 2"
        }
        return null
    }
}
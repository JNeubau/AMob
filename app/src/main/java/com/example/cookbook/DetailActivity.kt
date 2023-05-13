package com.example.cookbook

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class DetailActivity : AppCompatActivity() {

    private var time: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val frag: CookDetailFragment = supportFragmentManager.findFragmentById(R.id.detail_frag)
                as CookDetailFragment
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

    companion object {
        const val EXTRA_RECIPE_ID: String = "id"
    }
}
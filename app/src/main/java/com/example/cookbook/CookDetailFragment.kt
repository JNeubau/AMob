package com.example.cookbook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class CookDetailFragment : Fragment() {
    private var dishId: Long = 0;
    private var time: Int = 0

    fun setDish(id: Long) { this.dishId = id }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val timer = TimerFragment()
            val ft = childFragmentManager.beginTransaction()
            ft.add(R.id.timer_container, timer)
            ft.addToBackStack(null)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.commit()

            time = Dish.dishes[dishId.toInt()].time

            val args = Bundle()
            args.putInt("time", time)
            timer.arguments = args
        } else {
            dishId = savedInstanceState.getLong("dishId")
        }
    }

    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cook_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        val view: View? = view
        if (view != null) {
            val title: TextView = view.findViewById<View>(R.id.textTitle) as TextView
            val dish: Dish = Dish.dishes[dishId.toInt()]
            title.text = dish.name
            val description: TextView = view.findViewById(R.id.textDescription) as TextView
            description.text = dish.recipe
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putLong("dishId", dishId)
    }
}
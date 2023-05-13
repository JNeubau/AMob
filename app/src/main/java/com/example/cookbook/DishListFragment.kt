package com.example.cookbook

import android.content.Context
import android.os.Bundle
import android.support.v4.app.ListFragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.cookbook.placeholder.PlaceholderContent


class DishListFragment : ListFragment() {

    private var listener: Listener? = null

    internal interface Listener { fun itemClicked(id: Long) }

    override fun onCreateView (inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val names = arrayOfNulls<String>(Dish.dishes.size)
        for (i in names.indices) {
            names[i] = Dish.dishes[i].name
        }
        val adapter: ArrayAdapter<String> = ArrayAdapter(inflater.context,
            android.R.layout.simple_list_item_1, names)
        listAdapter = adapter

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.listener = context as Listener
    }

    override fun onListItemClick(listView: ListView?, itemView: View?, position: Int, id: Long) {
        if (listener != null) {
            listener!!.itemClicked(id)
        }
    }
}


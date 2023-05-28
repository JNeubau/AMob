package com.example.cookbook

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Tab2Fragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dishRecycler: RecyclerView = inflater.inflate(R.layout.fragment_tab2,
            container, false) as RecyclerView
        val names = arrayOfNulls<String>(Dish.dishes.size)
        for (i in names.indices) { names[i] = Dish.dishes[i].name }
        val images = arrayOfNulls<Int>(Dish.dishes.size)
        for (i in images.indices) { images[i] = Dish.dishes[i].imageResourceId }
        val adapter = CaptionedImagesAdapter(names, images)
        dishRecycler.adapter = adapter
        val layoutManager = GridLayoutManager(activity, 2)
        dishRecycler.layoutManager = layoutManager
        adapter.setListener(object : CaptionedImagesAdapter.Listener {
            override fun onClick(position: Int) {
                val intent = Intent(activity, CookDetailActivity::class.java)
                intent.putExtra(CookDetailActivity.EXTRA_COOK_ID, position)
                activity!!.startActivity(intent)
            }
        })
        return dishRecycler
    }
}

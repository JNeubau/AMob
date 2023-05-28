package com.example.cookbook

import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class CaptionedImagesAdapter(
    private var captions: Array<String?>,
    private var imageIds: Array<Int?>
) : RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {

    private lateinit var listener: Listener

    interface Listener { fun onClick(position: Int) }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val cv = LayoutInflater.from(parent.context).inflate(R.layout.card_captioned_image, parent, false) as CardView
        return ViewHolder(cv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView: CardView = holder.cardView
        val imageView: ImageView = cardView.findViewById<View>(R.id.info_image) as ImageView
        val drawable = ContextCompat.getDrawable(cardView.context, imageIds[position]!!)
        imageView.setImageDrawable(drawable)
        imageView.contentDescription = captions[position]
        val textView = cardView.findViewById<View>(R.id.info_text) as TextView
        textView.text = captions[position]
        cardView.setOnClickListener { listener.onClick(position) }
    }

    override fun getItemCount(): Int {
        return captions.size
    }

    class ViewHolder(var cardView: CardView) : RecyclerView.ViewHolder(cardView) {

//        fun ViewHolder(v: CardView) {
//            super.itemView
//            cardView = v
//        }
    }
}
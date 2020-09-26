package com.santtuhyvarinen.gameideagenerator.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.santtuhyvarinen.R

//RecyclerView adapter that manages bus stop item views
class FavoritesAdapter(private val context : Context, var favorites : List<String>) : RecyclerView.Adapter<FavoritesAdapter.ViewHolder>(){

    var favoritesAdapterListener: FavoritesAdapterListener? = null

    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        init {
            textView = view.findViewById(R.id.gameIdeaText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_favorite, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return favorites.size
    }

    //Set the bus stop info
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = favorites[position]

    }

    interface FavoritesAdapterListener {
        fun delete(index : Int)
    }
}
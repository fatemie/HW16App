package com.example.hw16app.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw16app.R
import com.example.hw16app.model.City


class FavoriteAdapter() :
    ListAdapter<City, FavoriteAdapter.ViewHolder>(FavoriteDiffCallback) {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var tvName = view.findViewById<TextView>(R.id.favoriteCityName)

        fun bind(city: City){
            tvName.text = city.name
        }
    }



    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): FavoriteAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.favorite_item, viewGroup , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.ViewHolder, position: Int) {
        val city = getItem(position)
        holder.bind(city)
    }

}

object FavoriteDiffCallback : DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.name == newItem.name
    }
}
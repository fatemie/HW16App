package com.example.hw16app.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw16app.R
import com.example.hw16app.model.City

class CityAdapter() :
    ListAdapter<City, CityAdapter.ViewHolder>(CityDiffCallback) {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var tvCityName = view.findViewById<TextView>(R.id.tvCityName)
        var ivFavorite = view.findViewById<ImageView>(R.id.ivFavorite)

        fun bind(city : City){
            tvCityName.text = city.name
            ivFavorite.setOnClickListener {
                ivFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CityAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.city_item, viewGroup , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityAdapter.ViewHolder, position: Int) {
        val city = getItem(position)
        holder.bind(city)
    }

}

object CityDiffCallback : DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.name == newItem.name
    }
}
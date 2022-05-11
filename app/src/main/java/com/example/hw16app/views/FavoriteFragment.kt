package com.example.hw16app.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.hw16app.databinding.FragmentFavoriteBinding
import com.example.hw16app.model.FavoriteCity
import com.example.hw16app.viewModel.CityViewModel
import com.example.hw16app.viewModel.FavoriteCityViewModel

class FavoriteFragment : Fragment() {
    lateinit var binding: FragmentFavoriteBinding
    private val vModel: CityViewModel by activityViewModels()
    //private val vModel: FavoriteCityViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        setRecyclerViewItemTouchListener()
    }

    private fun initList() {
        val adapter = FavoriteAdapter()
        binding.favoriteCitysRecyclerView.adapter = adapter
        adapter.submitList(vModel.favoriteList.value)
    }

    fun observe() {
//        val listObserver = Observer<ArrayList<FavoriteCity>> { it ->
//            val adapter = FavoriteAdapter()
//            binding.favoriteCitysRecyclerView.adapter = adapter
//            adapter.submitList(it)
//        }
//        vModel.favoriteList.observe(viewLifecycleOwner, listObserver)
        vModel.favoriteList.observe(viewLifecycleOwner){val adapter = FavoriteAdapter()
            binding.favoriteCitysRecyclerView.adapter = adapter
            adapter.submitList(it)}
    }


    private fun setRecyclerViewItemTouchListener() {
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                viewHolder1: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                val position = viewHolder.adapterPosition
                val city = vModel.favoriteList.value!![position]
                (vModel.favoriteList.value!! as ArrayList).removeAt(position)
                vModel.deleteCity(city)
                for (thisCity in vModel.cityList) {
                    if (thisCity.name == city.name) {
                        thisCity.isFavorite = false
                        vModel.addCity(thisCity)
                    }
                }
                //binding.favoriteCitysRecyclerView.adapter!!.notifyItemRemoved(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(binding.favoriteCitysRecyclerView)
    }

}
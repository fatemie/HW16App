package com.example.hw16app.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.hw16app.R
import com.example.hw16app.databinding.FragmentFavoriteBinding
import com.example.hw16app.model.City
import com.example.hw16app.viewModel.CityViewModel

class FavoriteFragment : Fragment() {
    lateinit var binding : FragmentFavoriteBinding
    private val vModel: CityViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        setRecyclerViewItemTouchListener()
    }

    private fun initList() {
        val adapter = FavoriteAdapter()
        binding.favoriteCitysRecyclerView.adapter = adapter
        adapter.submitList(vModel.favoriteList)
    }

    private fun setRecyclerViewItemTouchListener() {
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, viewHolder1: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                val position = viewHolder.adapterPosition
                val city = vModel.favoriteList[position]
                vModel.favoriteList.removeAt(position)
                for(thisCity in vModel.cityList){
                    if(thisCity == city){
                        thisCity.isFavorite = false
                    }
                }



                binding.favoriteCitysRecyclerView.adapter!!.notifyItemRemoved(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(binding.favoriteCitysRecyclerView)
    }

}
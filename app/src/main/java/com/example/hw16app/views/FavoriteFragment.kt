package com.example.hw16app.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.hw16app.R
import com.example.hw16app.databinding.FragmentFavoriteBinding
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
    }

    private fun initList() {
        val adapter = FavoriteAdapter()
        binding.favoriteCitysRecyclerView.adapter = adapter
        adapter.submitList(vModel.favoriteList)
    }
}
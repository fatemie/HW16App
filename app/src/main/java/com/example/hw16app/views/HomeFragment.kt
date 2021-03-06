package com.example.hw16app.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.hw16app.R
import com.example.hw16app.databinding.FragmentHomeBinding
import com.example.hw16app.model.City
import com.example.hw16app.model.FavoriteCity
import com.example.hw16app.repository.CityRepository
import com.example.hw16app.viewModel.CityViewModel

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    private val vModel: CityViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        setListener()
    }

    private fun initList() {
        val adapter = CityAdapter({ city -> vModel.onCityClicked(city)})
        binding.citysRecyclerView.adapter = adapter
        adapter.submitList(vModel.cityList)
    }
    fun setListener(){
        binding.buttonFavoritePage.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
        }
    }



}
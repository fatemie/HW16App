package com.example.hw16app.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.hw16app.R
import com.example.hw16app.databinding.FragmentHomeBinding
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
    }

    private fun initList() {
        val adapter = CityAdapter()
        binding.citysRecyclerView.adapter = adapter
        adapter.submitList(vModel.cityList)
    }

}
package com.example.itunesplayer.View.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.itunesplayer.Model.SongItems
import com.example.itunesplayer.View.Adapter.RockAdapter
import com.example.itunesplayer.ViewModel.MediaViewModel
import com.example.itunesplayer.databinding.RockAdapterBinding

open class RockFragment: Fragment() {
    private lateinit var binding: RockAdapterBinding
    private lateinit var adapter: RockAdapter

    private val viewModel: MediaViewModel by lazy {
        ViewModelProvider(
            this

        )[MediaViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = RockAdapterBinding.inflate(
            inflater,
            container,
            false
        )
        initObservables()
        initViews()
        return binding.root
    }


     open fun initViews() {
        adapter = RockAdapter(emptyList()){
        }
        binding.rockMusic.adapter=adapter
        binding.rockMusic.layoutManager=LinearLayoutManager(context)
    }


    open fun initObservables() {
        viewModel.allMusic()
        viewModel.rockMusic.observe(viewLifecycleOwner, Observer {
            updatedAdapter(it)
        })

    }

     open fun updatedAdapter(dataSet: List<SongItems>) {
        adapter.updatedList(dataSet)

    }



}
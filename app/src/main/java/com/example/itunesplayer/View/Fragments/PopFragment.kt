package com.example.itunesplayer.View.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.itunesplayer.Model.SongItems
import com.example.itunesplayer.View.Adapter.PopAdapter
import com.example.itunesplayer.View.Adapter.RockAdapter
import com.example.itunesplayer.ViewModel.MediaViewModel
import com.example.itunesplayer.databinding.PopAdapterBinding
import com.example.itunesplayer.databinding.RockAdapterBinding

open class PopFragment: Fragment() {
    private lateinit var binding: PopAdapterBinding
    private lateinit var adapter: PopAdapter

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
        binding = PopAdapterBinding.inflate(
            inflater,
            container,
            false
        )
        initObservables()
        initViews()
        Log.d("binding", "onCreateView: ${binding.root}")
        return binding.root
    }

    open fun initViews() {
        adapter = PopAdapter(emptyList()){
        }
        Log.d("test", "initViews: $adapter")
        binding.popMusic.adapter=adapter
        binding.popMusic.layoutManager= LinearLayoutManager(context)
    }

     open fun updatedAdapter(dataSet: List<SongItems>) {
        adapter.updatedList(dataSet)

    }

     open fun initObservables() {
        viewModel.allMusic()
        viewModel.popMusic.observe(viewLifecycleOwner,
            Observer {
                updatedAdapter(it)
            })
    }

}
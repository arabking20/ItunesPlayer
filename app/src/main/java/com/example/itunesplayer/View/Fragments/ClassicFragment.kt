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
import com.example.itunesplayer.View.Adapter.ClassicAdapter
import com.example.itunesplayer.ViewModel.MediaViewModel
import com.example.itunesplayer.databinding.ClassicAdapterBinding

open class ClassicFragment : Fragment() {
    private lateinit var binding: ClassicAdapterBinding
    private lateinit var adapter: ClassicAdapter

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
        binding = ClassicAdapterBinding.inflate(
            inflater,
            container,
            false
        )
        initObservables()
        initViews()
        return binding.root
    }

    open fun initViews() {
        adapter = ClassicAdapter(emptyList()){
        }
        binding.classicMusic.adapter=adapter
        binding.classicMusic.layoutManager= LinearLayoutManager(context)
    }

     open fun updatedAdapter(dataSet: List<SongItems>) {
        adapter.updatedList(dataSet)

    }

    open fun initObservables() {
        viewModel.allMusic()
        viewModel.classicMusic.observe(viewLifecycleOwner,
            Observer {
                updatedAdapter(it)
            })
    }

}
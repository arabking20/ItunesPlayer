package com.example.itunesplayer.View.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesplayer.Model.SongItems
import com.example.itunesplayer.R
import com.example.itunesplayer.databinding.ContainerBinding
import com.squareup.picasso.Picasso

class ClassicAdapter (var classicList:List<SongItems>,
                      private var openMusic:(SongItems) -> Unit )
    : RecyclerView.Adapter<ClassicAdapter.ViewHolder>(){
    class ViewHolder(private val binding: ContainerBinding):
        RecyclerView.ViewHolder(binding.root){

        fun onBinding(songItem: SongItems, openData:(SongItems)->Unit){
            binding.songTitle.text = songItem.artistName
            binding.songDesc.text = songItem.previewUrl
            binding.songPrice.text = songItem.trackPrice
            Picasso.get()
                .load(songItem.artworkUrl60)
                .placeholder(R.drawable.ic_baseline_music_video_24)
                .error(R.drawable.ic_baseline_music_video_24)
                .into(binding.homeBanner)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ClassicAdapter.ViewHolder(
            ContainerBinding
                .inflate(
                    LayoutInflater.from(parent.context)
                    ,parent
                    ,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBinding(classicList[position], openMusic)
    }

    override fun getItemCount(): Int {
        Log.d("Hi", "getItemCount:${classicList.size}")
        return classicList.size
    }
    fun updatedList(response: List<SongItems>){
        classicList = response
        Log.d("musicList", "updateList:${response} ")
        notifyDataSetChanged()
    }

}
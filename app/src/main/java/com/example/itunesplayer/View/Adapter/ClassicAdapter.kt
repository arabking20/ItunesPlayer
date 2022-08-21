package com.example.itunesplayer.View.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
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
            binding.artistName.text = songItem.artistName
            binding.songTitle.text = songItem.trackName
            binding.songPrice.text = songItem.trackPrice
            Picasso.get()
                .load(songItem.artworkUrl60)
                .placeholder(R.drawable.ic_baseline_music_video_24)
                .error(R.drawable.ic_baseline_music_video_24)
                .into(binding.homeBanner)

            binding.root.setOnClickListener{
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse(songItem.previewUrl)
                startActivity(binding.root.context,intent,null)
            }
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
        return classicList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updatedList(response: List<SongItems>){
        classicList = response
        notifyDataSetChanged()
    }

}
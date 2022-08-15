package com.example.itunesplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.itunesplayer.View.Fragments.ClassicFragment
import com.example.itunesplayer.View.Fragments.PopFragment
import com.example.itunesplayer.View.Fragments.RockFragment
import com.example.itunesplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container,RockFragment())
            .commit()
        binding.Home.setOnClickListener{
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,RockFragment())
                .commit()
        }
        binding.classicMusic.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,ClassicFragment())
                .commit()
        }
        binding.PopMusic.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,PopFragment())
                .commit()
        }
    }
}
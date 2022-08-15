package com.example.itunesplayer.Model.Remote

import com.example.itunesplayer.Model.ClassicMedia
import com.example.itunesplayer.Model.PopMedia
import com.example.itunesplayer.Model.RockMedia
import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET(ARGS_ROCK)
    fun getRockList(): Call<RockMedia>

    @GET(ARGS_CLASSIC)
    fun getClassList():Call<ClassicMedia>

    @GET(ARGS_POP)
    fun getPopList():Call<PopMedia>


}
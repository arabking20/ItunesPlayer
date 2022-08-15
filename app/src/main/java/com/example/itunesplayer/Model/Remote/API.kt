package com.example.itunesplayer.Model.Remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {


     val songApi: Service  by lazy {
        retrofit()
    }

    private fun retrofit(): Service
    {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service::class.java)
    }


}
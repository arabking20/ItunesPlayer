package com.example.itunesplayer.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.itunesplayer.Model.ClassicMedia
import com.example.itunesplayer.Model.PopMedia
import com.example.itunesplayer.Model.Remote.API
import com.example.itunesplayer.Model.RockMedia
import com.example.itunesplayer.Model.SongItems
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MediaViewModel : ViewModel()
{
    /**
     * Rock Message
     */
    var _rock = MutableLiveData<List<SongItems>>()
    val rockMusic: LiveData<List<SongItems>>
    get() = _rock
    /**
     * Classic Message
     */

    var _classic = MutableLiveData<List<SongItems>>()
    val classicMusic: LiveData<List<SongItems>>
        get() = _classic
    /**
     * Pop Message
     */

    var _pop = MutableLiveData<List<SongItems>>()
    val popMusic: LiveData<List<SongItems>>
        get() = _pop

    /**
     * Error Message
     */
    private val _errorMessages = MutableLiveData("")
    val errorMessages: LiveData<String>
        get() = _errorMessages

    fun allMusic() {

        val rockcall = API.songApi.getRockList()
        rockcall.enqueue(
            object : Callback<RockMedia> {
                override fun onResponse(call: Call<RockMedia>, response: Response<RockMedia>)
                {
                    if (response.isSuccessful) {
                        val body = response.body()
                        val resultMusic = body?.results
                        _rock.value = resultMusic

                    } else {
                        _errorMessages.value = response.message()
                    }
                }

                override fun onFailure(call: Call<RockMedia>, t: Throwable) {
                    t.printStackTrace()
                    _errorMessages.value = t.message ?: "Unknown error"
                    print(errorMessages)
                }

            }
        )

        val popCall = API.songApi.getPopList()
        popCall.enqueue(
            object : Callback<PopMedia> {
                override fun onResponse(call: Call<PopMedia>, response: Response<PopMedia>)
                {
                    if (response.isSuccessful) {
                        var body = response.body()
                        val resultMusic = body?.results
                        _pop.value = resultMusic

                    } else {
                        _errorMessages.value = response.message()
                    }
                }
                override fun onFailure(call: Call<PopMedia>, t: Throwable) {
                    t.printStackTrace()
                    _errorMessages.value = t.message ?: "Unknown error"
                    print(errorMessages)
                }

            }
        )



        val classifCall = API.songApi.getClassList()
        classifCall.enqueue(
            object : Callback<ClassicMedia> {
                override fun onResponse(call: Call<ClassicMedia>, response: Response<ClassicMedia>) {
                    if (response.isSuccessful) {
                        var body = response.body()
                        val resultMusic = body?.results
                        _classic.value = resultMusic



                    } else {
                        _errorMessages.value = response.message()
                    }
                }

                override fun onFailure(call: Call<ClassicMedia>, t: Throwable) {
                    t.printStackTrace()
                    _errorMessages.value = t.message ?: "Unknown error"
                    print(errorMessages)
                }

            }
        )
    }


}
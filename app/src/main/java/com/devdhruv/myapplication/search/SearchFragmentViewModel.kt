package com.devdhruv.myapplication.search

import androidx.lifecycle.ViewModel
import com.devdhruv.myapplication.network.iTunesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragmentViewModel: ViewModel() {

    private fun getArtistProperties(){
        iTunesApi.retrofitService.getProperties().enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}
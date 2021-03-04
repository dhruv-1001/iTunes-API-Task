package com.devdhruv.iTunesApi.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdhruv.iTunesApi.network.MusicProperty
import com.devdhruv.iTunesApi.network.iTunesApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchFragmentViewModel: ViewModel() {

    private var viewModelJob = Job()
    private var coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _response = MutableLiveData<String>()

    private val _properties = MutableLiveData<List<MusicProperty>>()

    val properties: LiveData<List<MusicProperty>>
        get() = _properties

    val response: LiveData<String>
        get() = _response

    val editTextContentSearch = MutableLiveData<String>()

    private fun getMusicProperties(){

        coroutineScope.launch {
            var temp = editTextContentSearch.value
            var term = ""
            if (temp != null) {
                temp = temp.trim()
                temp = temp.toLowerCase()
                for (i in temp.indices){
                    if (temp[i] == ' ') term += "+"
                    else term += temp[i]
                }
            }

            try{
                _properties.value = iTunesApi.retrofitService.getProperties(term)
            }
            catch (e: Exception){
                _properties.value = ArrayList()
            }
        }
    }

    fun onClickSearch(){
        getMusicProperties()
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
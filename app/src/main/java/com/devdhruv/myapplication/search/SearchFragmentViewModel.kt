package com.devdhruv.myapplication.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devdhruv.myapplication.network.iTunesApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SearchFragmentViewModel: ViewModel() {

    private var viewModelJob = Job()
    private var coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response


    private fun getMusicProperties(){

        coroutineScope.launch {
            var getPropertiesDeferred = iTunesApi.retrofitService.getProperties()
            try{
                var listResult = getPropertiesDeferred.await()
                _response.value = "Success: ${listResult.size} records received"
            }
            catch (e: Exception){
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
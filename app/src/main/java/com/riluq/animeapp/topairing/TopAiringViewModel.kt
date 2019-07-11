package com.riluq.animeapp.topairing

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riluq.animeapp.network.JikanMoeApi
import com.riluq.animeapp.network.TopAiring
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TopAiringViewModel: ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _topAiring = MutableLiveData<List<TopAiring>>()
    val topAiring: LiveData<List<TopAiring>>
        get() = _topAiring

    init {
        getTopAiring()
    }

    private fun getTopAiring() {
        coroutineScope.launch {
            val getTopAiringDeffered = JikanMoeApi.retrofitService.getTopAiringAsync()
            try {
                val listResult = getTopAiringDeffered.await().top
                if (listResult.size > 0) {
                    _topAiring.value = listResult
                }
                Log.i("TopAiringViewModel", "topAiring = ${topAiring.value?.get(0)?.titleTopAiring}")
            } catch (t: Throwable) {
                _topAiring.value = ArrayList()
                Log.i("TopAiringViewModel", t.message.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
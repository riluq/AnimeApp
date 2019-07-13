package com.riluq.animeapp.topairing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riluq.animeapp.JikanMoeApiStatus
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

    private val _status = MutableLiveData<JikanMoeApiStatus>()
    val status: LiveData<JikanMoeApiStatus>
        get() = _status

    init {
        getTopAiring()
    }

    fun getTopAiring() {
        coroutineScope.launch {
            val getTopAiringDeffered = JikanMoeApi.retrofitService.getTopAiringAsync()
            try {
                _status.value = JikanMoeApiStatus.Loading
                val listResult = getTopAiringDeffered.await().top
                if (listResult.size > 0) {
                    _topAiring.value = listResult
                }
                _status.value = JikanMoeApiStatus.Done
            } catch (t: Throwable) {
                _status.value = JikanMoeApiStatus.Error
                _topAiring.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
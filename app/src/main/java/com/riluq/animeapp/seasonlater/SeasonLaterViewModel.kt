package com.riluq.animeapp.seasonlater

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riluq.animeapp.JikanMoeApiStatus
import com.riluq.animeapp.network.JikanMoeApi
import com.riluq.animeapp.network.SeasonLater
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SeasonLaterViewModel: ViewModel() {

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _seasonLater = MutableLiveData<List<SeasonLater>>()
    val seasonLater: LiveData<List<SeasonLater>>
        get() = _seasonLater

    private val _status = MutableLiveData<JikanMoeApiStatus>()
    val status: LiveData<JikanMoeApiStatus>
        get() = _status

    init {
        getSeasonLater()
    }

    fun getSeasonLater() {
        coroutineScope.launch {
            val getSeasonLaterDeffered = JikanMoeApi.retrofitService.getSeasonLaterAsync()
            try {
                _status.value = JikanMoeApiStatus.Loading
                val listResult = getSeasonLaterDeffered.await().anime
                if (listResult.size > 0) {
                    _seasonLater.value = listResult
                }
                _status.value = JikanMoeApiStatus.Done
            } catch (t: Throwable) {
                _status.value = JikanMoeApiStatus.Error
                _seasonLater.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
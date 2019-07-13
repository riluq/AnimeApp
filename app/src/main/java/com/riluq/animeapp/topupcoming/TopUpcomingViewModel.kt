package com.riluq.animeapp.topupcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riluq.animeapp.JikanMoeApiStatus
import com.riluq.animeapp.network.JikanMoeApi
import com.riluq.animeapp.network.TopUpcoming
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TopUpcomingViewModel : ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    private val _topUpcoming = MutableLiveData<List<TopUpcoming>>()
    val topUpcoming: LiveData<List<TopUpcoming>>
        get() = _topUpcoming

    private val _status = MutableLiveData<JikanMoeApiStatus>()
    val status: LiveData<JikanMoeApiStatus>
        get() = _status

    init {
        getTopUpcoming()
    }

    fun getTopUpcoming() {
        coroutineScope.launch {
            val getTopUpcomingDeffered = JikanMoeApi.retrofitService.getTopUpcomingAsync()
            try {
                _status.value = JikanMoeApiStatus.Loading
                val listResult = getTopUpcomingDeffered.await().top
                if (listResult.size > 0) {
                    _topUpcoming.value = listResult
                }
                _status.value = JikanMoeApiStatus.Done
            } catch (t: Throwable) {
                _status.value = JikanMoeApiStatus.Error
                _topUpcoming.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
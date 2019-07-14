package com.riluq.animeapp.topfavorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riluq.animeapp.JikanMoeApiStatus
import com.riluq.animeapp.network.JikanMoeApi
import com.riluq.animeapp.network.TopFavorite
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TopFavoriteViewModel: ViewModel() {

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _topFavorite = MutableLiveData<List<TopFavorite>>()
    val topFavorite: LiveData<List<TopFavorite>>
        get() = _topFavorite

    private val _status = MutableLiveData<JikanMoeApiStatus>()
    val status: LiveData<JikanMoeApiStatus>
        get() = _status

    init {
        getTopFavorite()
    }

    fun getTopFavorite() {
        coroutineScope.launch {
            val getTopFavoriteDeffered = JikanMoeApi.retrofitService.getTopFavoriteAsync()
            try {
                _status.value = JikanMoeApiStatus.Loading
                val listResult = getTopFavoriteDeffered.await().top
                if (listResult.size > 0) {
                    _topFavorite.value = listResult
                }
                _status.value = JikanMoeApiStatus.Done
            } catch (t: Throwable) {
                _status.value = JikanMoeApiStatus.Error
                _topFavorite.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
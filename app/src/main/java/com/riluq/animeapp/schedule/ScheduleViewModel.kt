package com.riluq.animeapp.schedule

import androidx.lifecycle.ViewModel
import com.riluq.animeapp.network.JikanMoeApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ScheduleViewModel: ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getSchedule()
    }

    private fun getSchedule() {
        coroutineScope.launch {
            val getScheduleDeffered = JikanMoeApi.retrofitService.getScheduleAsync()
            try {
                val listResult = getScheduleDeffered.await()
            } catch (t: Throwable) {

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
package com.tb.task.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hike.assignment.api.ApiController
import com.tb.task.models.entities.TBClass
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {
    val classData = MutableLiveData<ArrayList<TBClass>>()
    val error = MutableLiveData<String>()
    val progress = MutableLiveData<Boolean>()

    init {
        progress.value = false
    }

    fun getClasses() {
        progress.value = true
        val job = CoroutineScope(Dispatchers.IO).launch {
            val response = async {
                ApiController.getClasses()
            }.await()
            withContext(Dispatchers.Main) {
                progress.value = false
                if (response.res != null) {
                    classData.value = response.res
                } else {
                    error.value = response.error?.reason
                }
            }
        }
    }
}
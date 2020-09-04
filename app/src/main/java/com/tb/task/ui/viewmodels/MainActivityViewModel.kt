package com.tb.task.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hike.assignment.api.ApiController
import com.tb.task.models.entities.TBClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    val classData = MutableLiveData<ArrayList<TBClass>>()
    val error = MutableLiveData<String>()

    fun getClasses() {
        val job = CoroutineScope(Dispatchers.IO).launch {
            val response = async {
                ApiController.getClasses()
            }.await()
            if (response.res != null) {
                classData.value = response.res
            } else {
                error.value = response.error?.reason
            }
        }
    }
}
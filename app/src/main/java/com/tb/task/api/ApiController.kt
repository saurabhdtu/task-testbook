package com.hike.assignment.api

import com.tb.task.api.ApiClient
import com.tb.task.api.BaseApiResponse
import com.tb.task.models.entities.TBClass


object ApiController {

    suspend fun getClasses(): BaseApiResponse<ArrayList<TBClass>> {
        val response = ApiClient.getClassApi()?.getClasses()?.execute()
        val baseResponse = BaseApiResponse<ArrayList<TBClass>>(response)
        if (response?.isSuccessful!! && response.body() != null) {
            baseResponse.res = response.body()!!.data.classes
        }
        return baseResponse
    }
}

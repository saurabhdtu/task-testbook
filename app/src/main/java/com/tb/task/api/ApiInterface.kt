package com.hike.assignment.api

import com.tb.task.models.responses.ClassResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("popular-courses")
    fun getClasses():Call<ClassResponse>
}
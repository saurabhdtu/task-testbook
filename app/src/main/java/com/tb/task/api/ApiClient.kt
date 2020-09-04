package com.tb.task.api

import com.hike.assignment.api.ApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    @Synchronized
    fun getClassApi(): ApiInterface? {
        if (restClient != null) return restClient
        val interceptor = HttpLoggingInterceptor()
        val okHttpClient = OkHttpClient.Builder()

        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient.interceptors().add(interceptor)
        okHttpClient.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClient.readTimeout(60, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(60, TimeUnit.SECONDS)
        val mRetrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://api.testbook.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
        restClient = mRetrofit.create(ApiInterface::class.java)
        return restClient
    }



    private var restClient: ApiInterface? = null

}
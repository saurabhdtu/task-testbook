package com.tb.task.api

import com.tb.task.models.responses.ClassResponse
import retrofit2.Response

open class BaseApiResponse<T>(response: Response<ClassResponse>?) {

    var res: T? = null
    var error: StandardError? = null

    init {
        error = if (response?.errorBody() != null) {
            StandardError(response.code(), response.message())
        } else {
            StandardError(509, "Unknown failure")
        }
    }
}
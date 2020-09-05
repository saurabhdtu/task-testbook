package com.hike.assignment.api

import com.tb.task.models.responses.ClassResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("popular-courses?auth_code=&X-Tb-Client=web,1.2&language=English&isPremium=true&includeIndividual=true&__projection={\"classes\":{\"_id\":1,\"title\":1,\"titles\":1,\"courseLogo\":1,\"isPremium\":1,\"slugUrl\":1,\"showLiveCourseTag\":1,\"classProperties\":{\"slug\":1,\"seatsAvailsInfo\":1,\"classType\":{\"lastEnrollmentDate\":1},\"color\":1},\"classInfo\":{\"facultiesImage\":1,\"classFeature\":{\"features\":{\"type\":1,\"count\":1}}}},\"labels\":1}")
    fun getClasses():Call<ClassResponse>
}
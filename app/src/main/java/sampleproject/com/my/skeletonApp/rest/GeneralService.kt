package sampleproject.com.my.skeletonApp.rest

import sampleproject.com.my.skeletonApp.rest.model.SampleDataResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface GeneralService {

    @GET("posts")
    fun getData(): Single<List<SampleDataResponse>>
}
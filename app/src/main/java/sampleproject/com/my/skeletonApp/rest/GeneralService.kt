package sampleproject.com.my.skeletonApp.rest

import sampleproject.com.my.skeletonApp.rest.model.SampleDataResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sampleproject.com.my.skeletonApp.rest.model.BadgeDataResponse

interface GeneralService {

    @GET("users?order=asc&sort=reputation&site=stackoverflow")
    fun getData(@Query("inName") inName: String): Single<SampleDataResponse>

    @GET("users/{ids}?order=desc&sort=reputation&site=stackoverflow")
    fun getUserData(@Path("ids") booking_id: String): Single<BadgeDataResponse>
}

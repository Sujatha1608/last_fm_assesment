package sampleproject.com.my.skeletonApp.rest

import sampleproject.com.my.skeletonApp.rest.model.SampleDataResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GeneralService {

    @GET("2.0/?method=album.search&format=json")
    fun getData(@Query("album") album: String,@Query("api_key") api_key: String): Single<SampleDataResponse>

}

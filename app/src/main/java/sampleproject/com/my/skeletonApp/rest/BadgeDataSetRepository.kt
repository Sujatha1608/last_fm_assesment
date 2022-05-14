package sampleproject.com.my.skeletonApp.rest

import io.reactivex.rxjava3.core.Single
import sampleproject.com.my.skeletonApp.rest.model.BadgeDataResponse
import sampleproject.com.my.skeletonApp.rest.model.SampleDataResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BadgeDataSetRepository @Inject constructor(private val apiServices: GeneralService){
    fun getBadgeInfo(id:String): Single<BadgeDataResponse>
    = apiServices.getUserData(id)
}
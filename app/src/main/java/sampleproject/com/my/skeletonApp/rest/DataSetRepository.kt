package sampleproject.com.my.skeletonApp.rest

import io.reactivex.rxjava3.core.Single
import sampleproject.com.my.skeletonApp.rest.model.SampleDataResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataSetRepository @Inject constructor(private val apiServices: GeneralService){
    fun getData(inName:String): Single<SampleDataResponse>
    = apiServices.getData(inName)
}
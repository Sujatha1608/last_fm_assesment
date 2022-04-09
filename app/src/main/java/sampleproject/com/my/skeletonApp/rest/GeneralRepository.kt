package sampleproject.com.my.skeletonApp.rest

import sampleproject.com.my.skeletonApp.rest.model.SampleDataResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GeneralRepository @Inject constructor(private val api: GeneralService){

    fun getData(): Single<SampleDataResponse> =
            api.getData()
}
package sampleproject.com.my.skeletonApp.rest

import io.reactivex.rxjava3.core.Single
import sampleproject.com.my.skeletonApp.core.util.SchedulerProvider
import sampleproject.com.my.skeletonApp.rest.model.SampleDataResponse
import sampleproject.com.my.skeletonApp.rest.model.UseCase

class DatasetUseCase(schedulerProvider: SchedulerProvider, private val getDataRepository: DataSetRepository)
    : UseCase<String,SampleDataResponse>(schedulerProvider) {
    override fun buildUseCaseObservable(params: String?): Single<SampleDataResponse> {
        return getDataRepository.getData(params!!)
    }

}
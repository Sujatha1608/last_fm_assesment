package sampleproject.com.my.skeletonApp.rest

import io.reactivex.rxjava3.core.Single
import sampleproject.com.my.skeletonApp.core.util.SchedulerProvider
import sampleproject.com.my.skeletonApp.rest.model.SampleDataResponse

class DatasetUseCase(schedulerProvider: SchedulerProvider, private val getDataRepository: DataSetRepository)
    : UseCaseWithOutParam<List<SampleDataResponse>>(schedulerProvider) {
    override fun buildUseCaseObservable(): Single<List<SampleDataResponse>> {
        return getDataRepository.getData()
    }

}
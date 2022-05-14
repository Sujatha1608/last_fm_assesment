package sampleproject.com.my.skeletonApp.rest

import io.reactivex.rxjava3.core.Single
import sampleproject.com.my.skeletonApp.core.util.SchedulerProvider
import sampleproject.com.my.skeletonApp.rest.model.BadgeDataResponse
import sampleproject.com.my.skeletonApp.rest.model.SampleDataResponse
import sampleproject.com.my.skeletonApp.rest.model.UseCase

class BadgeDataUseCase(schedulerProvider: SchedulerProvider, private val getDataRepository: BadgeDataSetRepository)
    : UseCase<String,BadgeDataResponse>(schedulerProvider) {
    override fun buildUseCaseObservable(params: String?): Single<BadgeDataResponse> {
        return getDataRepository.getBadgeInfo(params!!)
    }

}
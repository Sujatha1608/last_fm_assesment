package sampleproject.com.my.skeletonApp.rest

import io.reactivex.rxjava3.core.Single
import sampleproject.com.my.skeletonApp.core.util.SchedulerProvider


abstract class UseCaseWithOutParam<T> protected constructor(private val schedulers: SchedulerProvider) {

    protected abstract fun buildUseCaseObservable(): Single<T>

    fun execute(): Single<T> {
        return buildUseCaseObservable()
            .subscribeOn(schedulers.subscribeOn)
            .observeOn(schedulers.observeOn)
    }
}

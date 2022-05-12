package sampleproject.com.my.skeletonApp.rest.model

import io.reactivex.rxjava3.core.Single
import sampleproject.com.my.skeletonApp.core.util.SchedulerProvider


abstract class UseCase<in Params, T> protected constructor(private val schedulers: SchedulerProvider) {

    protected abstract fun buildUseCaseObservable(params: Params?): Single<T>

    fun execute(params: Params? = null): Single<T> {
        return buildUseCaseObservable(params)
            .subscribeOn(schedulers.subscribeOn)
            .observeOn(schedulers.observeOn)
    }
}

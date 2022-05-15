package sampleproject.com.my.skeletonApp.rest.model

import io.reactivex.rxjava3.core.Single
import sampleproject.com.my.skeletonApp.core.util.SchedulerProvider


abstract class UseCase<in Params, in Params2, T> protected constructor(private val schedulers: SchedulerProvider) {

    protected abstract fun buildUseCaseObservable(params: Params?, param2: Params2?): Single<T>

    fun execute(params: Params? = null, param2: Params2? = null): Single<T> {
        return buildUseCaseObservable(params, param2)
            .subscribeOn(schedulers.subscribeOn)
            .observeOn(schedulers.observeOn)
    }
}
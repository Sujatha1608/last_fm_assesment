package sampleproject.com.my.skeletonApp.core.util

import io.reactivex.rxjava3.core.Scheduler


interface SchedulerProvider {
    val subscribeOn: Scheduler
    val observeOn: Scheduler
    val newThread: Scheduler
}
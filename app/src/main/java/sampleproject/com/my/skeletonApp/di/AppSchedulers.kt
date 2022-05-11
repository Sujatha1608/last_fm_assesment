package sampleproject.com.my.skeletonApp.di

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io
import sampleproject.com.my.skeletonApp.core.util.SchedulerProvider

class AppSchedulers : SchedulerProvider {
    override val subscribeOn: Scheduler
        get() = io()
    override val observeOn: Scheduler
        get() = AndroidSchedulers.mainThread()
    override val newThread: Scheduler
        get() = Schedulers.newThread()
}

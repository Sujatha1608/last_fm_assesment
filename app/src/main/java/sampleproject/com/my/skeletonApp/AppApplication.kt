package sampleproject.com.my.skeletonApp

import sampleproject.com.my.skeletonApp.di.DaggerAppComponent
import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.github.ajalt.timberkt.Timber
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class AppApplication: Application(), HasAndroidInjector, LifecycleObserver {

    companion object {
        @get:Synchronized
        lateinit var instance: AppApplication
    }

    @Inject
    lateinit var activityDispatcher: DispatchingAndroidInjector<Any>
    var isOnBackground = false

    override fun androidInjector(): AndroidInjector<Any> {
        return activityDispatcher
    }

    override fun onCreate() {
        super.onCreate()
        initLogger()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(timber.log.Timber.DebugTree())
        }
    }

}
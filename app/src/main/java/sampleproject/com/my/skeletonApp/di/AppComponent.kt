package sampleproject.com.my.skeletonApp.di

import sampleproject.com.my.skeletonApp.AppApplication
import sampleproject.com.my.skeletonApp.di.modules.ActivityBuilder
import sampleproject.com.my.skeletonApp.di.modules.DatabaseModule
import sampleproject.com.my.skeletonApp.di.modules.NetworkModule
import sampleproject.com.my.skeletonApp.di.modules.ViewModelModules
import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AndroidInjectionModule::class),
    (ActivityBuilder::class), (NetworkModule::class),
    (DatabaseModule::class), (ViewModelModules::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AppApplication)
}
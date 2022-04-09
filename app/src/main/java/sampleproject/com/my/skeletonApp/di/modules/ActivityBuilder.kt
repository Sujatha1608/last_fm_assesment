package sampleproject.com.my.skeletonApp.di.modules

import sampleproject.com.my.skeletonApp.feature.login.GetDataActivity
import sampleproject.com.my.skeletonApp.feature.login.GetDataActivityModule
import sampleproject.com.my.skeletonApp.feature.display.DisplayInfoActivity
import sampleproject.com.my.skeletonApp.feature.display.DisplayInfoActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(GetDataActivityModule::class)])
    abstract fun bindLoginActivity(): GetDataActivity

    @ContributesAndroidInjector(modules = [(DisplayInfoActivityModule::class)])
    abstract fun bindMainActivity() : DisplayInfoActivity

}
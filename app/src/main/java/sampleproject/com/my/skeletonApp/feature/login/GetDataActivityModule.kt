package sampleproject.com.my.skeletonApp.feature.login

import sampleproject.com.my.skeletonApp.AppPreference
import sampleproject.com.my.skeletonApp.core.util.SchedulerProvider
import sampleproject.com.my.skeletonApp.rest.GeneralRepository
import dagger.Module
import dagger.Provides


@Module
class GetDataActivityModule {
    @Provides
    fun provideViewModel(schedulerProvider: SchedulerProvider, generalRepository: GeneralRepository, appPreference: AppPreference)
    = GetDataViewModel(schedulerProvider,generalRepository,appPreference)
}
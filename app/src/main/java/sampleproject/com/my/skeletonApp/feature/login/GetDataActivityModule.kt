package sampleproject.com.my.skeletonApp.feature.login

import dagger.Module
import dagger.Provides


@Module
class GetDataActivityModule {
    @Provides
    fun provideViewModel() = GetDataViewModel()
}
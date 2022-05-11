package sampleproject.com.my.skeletonApp.feature.display

import sampleproject.com.my.skeletonApp.AppPreference
import dagger.Module
import dagger.Provides
import sampleproject.com.my.skeletonApp.rest.DatasetUseCase


@Module
class DisplayInfoActivityModule {
    @Provides
    fun provideViewModel(dataSettUseCase: DatasetUseCase, appPreference: AppPreference) = DisplayInfoViewModel(dataSettUseCase, appPreference)
}
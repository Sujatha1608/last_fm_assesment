package sampleproject.com.my.skeletonApp.feature.display

import dagger.Module
import dagger.Provides
import sampleproject.com.my.skeletonApp.rest.BadgeDataUseCase
import sampleproject.com.my.skeletonApp.rest.DatasetUseCase


@Module
class DisplayInfoActivityModule {
    @Provides
    fun provideViewModel(dataSettUseCase: DatasetUseCase) = DisplayInfoViewModel(dataSettUseCase)
}
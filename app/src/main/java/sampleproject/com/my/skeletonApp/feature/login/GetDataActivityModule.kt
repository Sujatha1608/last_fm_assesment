package sampleproject.com.my.skeletonApp.feature.login

import dagger.Module
import dagger.Provides
import sampleproject.com.my.skeletonApp.rest.BadgeDataUseCase


@Module
class GetDataActivityModule {
    @Provides
    fun provideViewModel(badgeDataUseCase: BadgeDataUseCase) = GetDataViewModel(badgeDataUseCase)
}
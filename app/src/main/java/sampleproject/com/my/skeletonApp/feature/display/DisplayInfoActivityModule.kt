package sampleproject.com.my.skeletonApp.feature.display

import sampleproject.com.my.skeletonApp.AppPreference
import sampleproject.com.my.skeletonApp.database.DatabaseRepository
import dagger.Module
import dagger.Provides


@Module
class DisplayInfoActivityModule {
    @Provides
    fun provideViewModel(databaseRepository: DatabaseRepository, appPreference: AppPreference) = DisplayInfoViewModel(databaseRepository, appPreference)
}
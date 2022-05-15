package sampleproject.com.my.skeletonApp.di.modules

import dagger.Module
import dagger.Provides
import sampleproject.com.my.skeletonApp.core.util.SchedulerProvider
import sampleproject.com.my.skeletonApp.rest.DataSetRepository
import sampleproject.com.my.skeletonApp.rest.DatasetUseCase


@Module
class DomainModules {

    @Provides
    fun providesLoginUseCase(schedulers: SchedulerProvider, dataRepository: DataSetRepository) =
        DatasetUseCase(schedulers, dataRepository)
}



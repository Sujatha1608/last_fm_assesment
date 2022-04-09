package sampleproject.com.my.skeletonApp.di.modules

import sampleproject.com.my.skeletonApp.database.AppDatabase
import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase {
        return AppDatabase.getInstance(application.applicationContext)
    }

    @Provides
    fun providesUserDao(db: AppDatabase) = db.userDao()
}
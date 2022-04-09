package sampleproject.com.my.skeletonApp.di.modules

import sampleproject.com.my.skeletonApp.feature.login.GetDataViewModel
import sampleproject.com.my.skeletonApp.feature.display.DisplayInfoViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModules {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory):
            ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DisplayInfoViewModel::class)
    internal abstract fun provideMainViewModel(viewModel: DisplayInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GetDataViewModel::class)
    internal abstract fun provideLoginViewModel(viewModel: GetDataViewModel): ViewModel

}

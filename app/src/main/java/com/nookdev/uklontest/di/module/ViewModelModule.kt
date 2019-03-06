package com.nookdev.uklontest.di.module

import androidx.lifecycle.ViewModel
import com.nookdev.uklontest.di.ViewModelKey
import com.nookdev.uklontest.di.scope.PerActivity
import com.nookdev.uklontest.presentation.viewmodel.main.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

//    @Binds
//    @PerActivity
//    @IntoMap
//    @ViewModelKey(SignInViewModel::class)
//    abstract fun bindSignInViewModel(myViewModel: SignInViewModel): ViewModel
//
//
    @Binds
    @PerActivity
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(model: MainActivityViewModel): ViewModel
//
//    @Binds
//    @PerActivity
//    @IntoMap
//    @ViewModelKey(HomeViewModel::class)
//    abstract fun bindHomeViewModel(model: HomeViewModel): ViewModel
//
//    @Binds
//    @PerActivity
//    @IntoMap
//    @ViewModelKey(TimeLogsViewModel::class)
//    abstract fun bindTimeLogsViewModel(mode: TimeLogsViewModel): ViewModel
}
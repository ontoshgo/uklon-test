package com.nookdev.uklontest.di.module

import androidx.lifecycle.ViewModelProvider
import com.nookdev.uklontest.di.scope.PerActivity
import com.nookdev.uklontest.presentation.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    @PerActivity
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}
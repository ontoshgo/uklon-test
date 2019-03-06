package com.nookdev.uklontest.di.component

import android.app.Activity
import androidx.lifecycle.ViewModelProvider
import com.nookdev.uklontest.di.module.ActivityModule
import com.nookdev.uklontest.di.module.ViewModelFactoryModule
import com.nookdev.uklontest.di.module.ViewModelModule
import com.nookdev.uklontest.di.scope.PerActivity
import com.nookdev.uklontest.domain.repository.DataRepository
import com.nookdev.uklontest.presentation.view.MainActivity
import dagger.Component

@PerActivity
@Component(
    dependencies = [AppComponent::class],
    modules = [
        ActivityModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class
    ]
)
interface ActivityComponent {
    fun inject(target: MainActivity)
    fun activity(): Activity
    fun dataRepository(): DataRepository
    fun daggerViewModelFactory(): ViewModelProvider.Factory
}
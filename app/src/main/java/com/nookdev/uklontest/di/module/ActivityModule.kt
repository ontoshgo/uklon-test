package com.nookdev.uklontest.di.module

import android.app.Activity
import com.nookdev.uklontest.di.scope.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    @PerActivity
    fun provideActivity(): Activity = activity
}
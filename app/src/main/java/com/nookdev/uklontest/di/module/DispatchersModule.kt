package com.nookdev.uklontest.di.module

import com.nookdev.uklontest.di.qualifier.ExecutionDispatcherQualifier
import com.nookdev.uklontest.di.qualifier.MainDispatcherQualifier
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class DispatchersModule {

    @Singleton
    @ExecutionDispatcherQualifier
    @Provides
    fun provideExecutionDispatcher():Scheduler = Schedulers.io()

    @Singleton
    @MainDispatcherQualifier
    @Provides
    fun provideMainDispatcher():Scheduler = AndroidSchedulers.mainThread()
}
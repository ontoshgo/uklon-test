package com.nookdev.uklontest.di.component

import com.nookdev.uklontest.di.module.ContextModule
import com.nookdev.uklontest.di.module.DispatchersModule
import com.nookdev.uklontest.di.module.NetworkModule
import com.nookdev.uklontest.di.module.RepositoryModule
import com.nookdev.uklontest.di.qualifier.ExecutionDispatcherQualifier
import com.nookdev.uklontest.di.qualifier.MainDispatcherQualifier
import com.nookdev.uklontest.domain.repository.DataRepository
import dagger.Component
import io.reactivex.Scheduler
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, NetworkModule::class, RepositoryModule::class, DispatchersModule::class])
interface AppComponent {
    fun repository(): DataRepository

    @ExecutionDispatcherQualifier
    fun exectionDispatcher(): Scheduler

    @MainDispatcherQualifier
    fun mainDispatcher(): Scheduler
}
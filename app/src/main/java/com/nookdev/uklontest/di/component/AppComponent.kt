package com.nookdev.uklontest.di.component

import com.nookdev.uklontest.di.module.ContextModule
import com.nookdev.uklontest.di.module.NetworkModule
import com.nookdev.uklontest.di.module.RepositoryModule
import com.nookdev.uklontest.domain.repository.DataRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, NetworkModule::class, RepositoryModule::class])
interface AppComponent {
    fun repository(): DataRepository
}
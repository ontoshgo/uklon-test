package com.nookdev.uklontest.di.module

import com.nookdev.uklontest.data.NetworkStateChecker
import com.nookdev.uklontest.data.NetworkStateCheckerImpl
import com.nookdev.uklontest.data.ds.DataStore
import com.nookdev.uklontest.data.ds.LocalDataStoreImpl
import com.nookdev.uklontest.data.ds.RemoteDataStoreImpl
import com.nookdev.uklontest.data.repository.DataRepositoryImpl
import com.nookdev.uklontest.di.qualifier.LocalDataStoreQualifier
import com.nookdev.uklontest.di.qualifier.RemoteDataStoreQualifier
import com.nookdev.uklontest.domain.repository.DataRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [ContextModule::class, NetworkModule::class])
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideNetworkStateChecker(impl: NetworkStateCheckerImpl): NetworkStateChecker

    @Binds
    @Singleton
    @LocalDataStoreQualifier
    abstract fun provideLocalDataStore(store: LocalDataStoreImpl): DataStore

    @Binds
    @Singleton
    @RemoteDataStoreQualifier
    abstract fun provideRemoteDataStore(store: RemoteDataStoreImpl): DataStore

    @Binds
    @Singleton
    abstract fun bindRepository(repo: DataRepositoryImpl): DataRepository
}
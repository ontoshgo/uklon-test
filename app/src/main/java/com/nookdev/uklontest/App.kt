package com.nookdev.uklontest

import android.app.Activity
import android.app.Application
import android.content.Context
import com.nookdev.uklontest.di.component.DaggerAppComponent
import com.nookdev.uklontest.di.module.ContextModule
import com.nookdev.uklontest.di.module.NetworkModule
import com.nookdev.uklontest.presentation.view.base.BaseFragment
import timber.log.Timber

class App : Application(){
    companion object {
        operator fun get(activity: Activity): App {
            return activity.application as App
        }

        operator fun get(fragment: BaseFragment<*, *>): App {
            return fragment.getActivity()?.application as App
        }

        operator fun get(context: Context): App {
            return context as App
        }
    }

    val appComponent by lazy {
        DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .networkModule(NetworkModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}
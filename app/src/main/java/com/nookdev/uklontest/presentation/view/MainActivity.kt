package com.nookdev.uklontest.presentation.view

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nookdev.uklontest.App
import com.nookdev.uklontest.R
import com.nookdev.uklontest.di.component.ActivityComponent
import com.nookdev.uklontest.di.component.DaggerActivityComponent
import com.nookdev.uklontest.di.module.ActivityModule
import com.nookdev.uklontest.presentation.view.base.BaseActivity
import com.nookdev.uklontest.presentation.viewmodel.main.MainActivityViewModel
import com.nookdev.uklontest.util.injectViewModel

class MainActivity : BaseActivity<MainActivityViewModel, Unit>() {

    companion object {
        operator fun get(fragment: Fragment): MainActivity {
            return fragment.activity as MainActivity
        }
    }

    lateinit var component: ActivityComponent

    override fun provideLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun provideViewModel(
        viewModelFactory: ViewModelProvider.Factory
    ): MainActivityViewModel {
        return injectViewModel(viewModelFactory)
    }

    override fun performInjection() {
        component = DaggerActivityComponent
            .builder()
            .activityModule(ActivityModule(this))
            .appComponent(App[this].appComponent)
            .build()
            .also {
                it.inject(this)
            }
    }

    override fun getContainerId(): Int = R.id.mainNavHostFragment

    override fun onUiModelUpdated(newModel: Unit) {
    }
}

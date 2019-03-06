package com.nookdev.uklontest.presentation.view.base

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.nookdev.uklontest.presentation.viewmodel.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseActivity<V : BaseViewModel<UiModel>, UiModel> : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    protected lateinit var viewModel: V

    protected val navController by lazy {
        Navigation.findNavController(this, getContainerId())
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @IdRes
    abstract fun getContainerId(): Int

    abstract fun provideLayoutId(): Int

    abstract fun provideViewModel(viewModelFactory: ViewModelProvider.Factory): V

    abstract fun performInjection()

    abstract fun onUiModelUpdated(newModel: UiModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        performInjection()
        viewModel = provideViewModel(viewModelFactory)
        viewModel.uiModelData.observe(this, Observer {
            onUiModelUpdated(it)
        })
    }

    override fun onBackPressed() {
        try {
            val containerId = getContainerId()
            val currentFragment = supportFragmentManager.findFragmentById(
                containerId
            ) as? BaseFragment<*, *>
                ?: throw IllegalStateException()
            if (!currentFragment.onBackPressed()) {
                processLocalPresenterBackPress()
            }
        } catch (e: IllegalStateException) {
            processLocalPresenterBackPress()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    private fun processLocalPresenterBackPress() {
        val consumed = viewModel.onBackPressed()
        if (!consumed) {
            super.onBackPressed()
        }
    }
}
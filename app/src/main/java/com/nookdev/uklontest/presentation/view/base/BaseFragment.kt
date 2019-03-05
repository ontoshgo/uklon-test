package com.nookdev.uklontest.presentation.view.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.nookdev.uklontest.presentation.viewmodel.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment<ViewModel : BaseViewModel<UiModel>, UiModel> : Fragment() {

    private val compositeDisposable = CompositeDisposable()

    protected lateinit var navController: NavController

    protected lateinit var viewModel: ViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performInjection()
        viewModel = provideViewModel(viewModelFactory)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController(view)
        viewModel.uiModelData.observe(this, Observer {
            onUiModelUpdated(it)
        })
    }

    abstract fun performInjection()

    abstract fun getLayoutId(): Int

    abstract fun provideViewModel(viewModelFactory: ViewModelProvider.Factory): ViewModel

    abstract fun onUiModelUpdated(newModel: UiModel)

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear()
    }

    open fun onBackPressed(): Boolean = viewModel.onBackPressed()
}
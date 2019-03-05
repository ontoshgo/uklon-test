package com.nookdev.uklontest.presentation.viewmodel.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<UiModel> : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val uiModelData = MutableLiveData<UiModel>()

    open fun onBackPressed(): Boolean = false

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    protected fun postUiModel(model: UiModel) {
        uiModelData.postValue(model)
    }

}
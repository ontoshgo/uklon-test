package com.nookdev.uklontest.presentation.viewmodel.posts

import com.nookdev.uklontest.di.qualifier.ExecutionDispatcherQualifier
import com.nookdev.uklontest.di.qualifier.MainDispatcherQualifier
import com.nookdev.uklontest.domain.repository.DataRepository
import com.nookdev.uklontest.presentation.viewmodel.base.BaseViewModel
import io.reactivex.Scheduler
import javax.inject.Inject

class PostsViewModel @Inject constructor(
    @MainDispatcherQualifier private val mainThread: Scheduler,
    @ExecutionDispatcherQualifier private val executionThread: Scheduler,
    private val dataRepository: DataRepository
) : BaseViewModel<PostsUiModel>() {

    fun refresh() {
        dataRepository.getPosts()
            .subscribeOn(executionThread)
            .observeOn(mainThread)
            .subscribe { posts, error ->
                if (error != null) {
                    postUiModel(PostsUiModel(errors = listOf(error)))
                    return@subscribe
                }
                postUiModel(PostsUiModel(posts = posts))
            }
            .bindToLifeCycle()
    }

}
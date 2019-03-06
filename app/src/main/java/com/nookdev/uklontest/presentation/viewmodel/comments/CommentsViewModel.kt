package com.nookdev.uklontest.presentation.viewmodel.comments

import com.nookdev.uklontest.di.qualifier.ExecutionDispatcherQualifier
import com.nookdev.uklontest.di.qualifier.MainDispatcherQualifier
import com.nookdev.uklontest.domain.model.Comment
import com.nookdev.uklontest.domain.model.Post
import com.nookdev.uklontest.domain.model.User
import com.nookdev.uklontest.domain.repository.DataRepository
import com.nookdev.uklontest.presentation.viewmodel.base.BaseViewModel
import io.reactivex.Scheduler
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class CommentsViewModel @Inject constructor(
    @MainDispatcherQualifier private val mainThread: Scheduler,
    @ExecutionDispatcherQualifier private val executionThread: Scheduler,
    private val dataRepository: DataRepository
) : BaseViewModel<CommentsUiModel>() {

    fun refresh(post: Post) {
        postUiModel(CommentsUiModel(isLoading = true))
        dataRepository.getComments(postId = post.id)
            .zipWith(dataRepository.getUserById(userId = post.userId),
                BiFunction { comments: List<Comment>, user: User ->
                    CommentsUiModel(isLoading = false, user = user, comments = comments)
                }
            ).subscribeOn(executionThread)
            .observeOn(mainThread)
            .subscribe { uiModel, error ->
                if (error != null) {
                    postUiModel(CommentsUiModel(isLoading = false, errors = listOf(error)))
                    return@subscribe
                }
                postUiModel(uiModel)
            }.bindToLifeCycle()
    }
}
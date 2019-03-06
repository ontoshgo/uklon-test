package com.nookdev.uklontest.presentation.viewmodel.comments

import com.nookdev.uklontest.domain.model.Comment
import com.nookdev.uklontest.domain.model.User

data class CommentsUiModel(
    val user: User? = null,
    val comments: List<Comment> = emptyList(),
    val errors: List<Throwable> = emptyList()
)
package com.nookdev.uklontest.presentation.viewmodel.posts

import com.nookdev.uklontest.domain.model.Post

data class PostsUiModel(
    val posts: List<Post> = emptyList(),
    val errors: List<Throwable> = emptyList()
)
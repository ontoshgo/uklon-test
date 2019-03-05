package com.nookdev.uklontest.data.entity

data class CommentEntity(
    val id: Int,
    val postId: Int,
    val name: String,
    val body: String
)
package com.nookdev.uklontest.domain.repository

import com.nookdev.uklontest.domain.model.Comment
import com.nookdev.uklontest.domain.model.Post
import com.nookdev.uklontest.domain.model.User
import io.reactivex.Single

interface DataRepository {
    fun getPosts(): Single<List<Post>>
    fun getComments(postId: Int): Single<List<Comment>>
    fun getUserById(userId: Int): Single<User>
}
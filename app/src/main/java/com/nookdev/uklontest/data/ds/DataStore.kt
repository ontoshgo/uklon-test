package com.nookdev.uklontest.data.ds

import com.nookdev.uklontest.data.entity.CommentEntity
import com.nookdev.uklontest.data.entity.PostEntity
import com.nookdev.uklontest.data.entity.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

interface DataStore {
    fun getPosts(): Single<List<PostEntity>>
    fun getCommentsByPost(postId: Int): Single<List<CommentEntity>>
    fun getUserById(id: Int): Single<UserEntity>
    fun savePosts(posts: List<PostEntity>): Completable
    fun saveComments(comments: List<CommentEntity>): Completable
    fun saveUser(user: UserEntity): Completable
}
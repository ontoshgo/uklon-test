package com.nookdev.uklontest.data.ds

import com.nookdev.uklontest.data.entity.CommentEntity
import com.nookdev.uklontest.data.entity.PostEntity
import com.nookdev.uklontest.data.entity.UserEntity
import com.nookdev.uklontest.domain.exception.ContentNotFoundException
import io.reactivex.Single
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

class LocalDataStoreImpl @Inject constructor(

) : DataStore {

    private val posts: MutableMap<Int, PostEntity> = ConcurrentHashMap()
    private val users: MutableMap<Int, UserEntity> = ConcurrentHashMap()
    private val comments: MutableMap<Int, CommentEntity> = ConcurrentHashMap()

    override fun getPosts(): Single<List<PostEntity>> {
        return Single.just(posts.values.toList())
    }

    override fun getCommentsByPost(postId: Int): Single<List<CommentEntity>> {
        return Single.just(getCommentsByPostId(postId))
    }

    override fun getUserById(id: Int): Single<UserEntity> {
        val user = getLocalUserById(id) ?: return Single.error(ContentNotFoundException())
        return Single.just(user)
    }

    override fun savePosts(posts: List<PostEntity>) {
        posts.forEach {
            this.posts[it.id] = it
        }
    }

    override fun saveComments(comments: List<CommentEntity>) {
        comments.forEach {
            this.comments[it.id] = it
        }
    }

    override fun saveUser(user: UserEntity) {
        users[user.id] = user
    }

    private fun getCommentsByPostId(postId: Int): List<CommentEntity> {
        return comments.asSequence()
            .filter {
                it.value.postId == postId
            }.map {
                it.value
            }
            .toList()
    }

    private fun getLocalUserById(userId: Int): UserEntity? {
        return users[userId]
    }
}
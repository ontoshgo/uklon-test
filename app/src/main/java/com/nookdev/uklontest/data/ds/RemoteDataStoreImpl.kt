package com.nookdev.uklontest.data.ds

import com.nookdev.uklontest.data.entity.CommentEntity
import com.nookdev.uklontest.data.entity.PostEntity
import com.nookdev.uklontest.data.entity.UserEntity
import com.nookdev.uklontest.data.mapper.CommentEntityMapper
import com.nookdev.uklontest.data.mapper.PostEntityMapper
import com.nookdev.uklontest.data.mapper.UserEntityMapper
import com.nookdev.uklontest.data.net.RemoteApi
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataStoreImpl @Inject constructor(
    private val api: RemoteApi,
    private val commentEntityMapper: CommentEntityMapper,
    private val postEntityMapper: PostEntityMapper,
    private val userEntityMapper: UserEntityMapper
) : DataStore {
    override fun getPosts(): Single<List<PostEntity>> {
        return api.getPosts()
            .map {
                postEntityMapper.mapAll(it)
            }
    }

    override fun getCommentsByPost(postId: Int): Single<List<CommentEntity>> {
        return api.getCommentsByPost(postId)
            .map {
                commentEntityMapper.mapAll(it)
            }
    }

    override fun getUserById(id: Int): Single<UserEntity> {
        return api.getUserById(id)
            .map {
                userEntityMapper.map(it)
            }
    }

    override fun savePosts(posts: List<PostEntity>): Completable {
        throw NotImplementedError("For local ds use only")
    }

    override fun saveComments(comments: List<CommentEntity>): Completable {
        throw NotImplementedError("For local ds use only")
    }

    override fun saveUser(user: UserEntity): Completable {
        throw NotImplementedError("For local ds use only")
    }
}
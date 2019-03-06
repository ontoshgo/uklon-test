package com.nookdev.uklontest.data.repository

import com.nookdev.uklontest.data.NetworkStateChecker
import com.nookdev.uklontest.data.ds.DataStore
import com.nookdev.uklontest.di.qualifier.LocalDataStoreQualifier
import com.nookdev.uklontest.di.qualifier.RemoteDataStoreQualifier
import com.nookdev.uklontest.domain.mapper.CommentMapper
import com.nookdev.uklontest.domain.mapper.PostMapper
import com.nookdev.uklontest.domain.mapper.UserMapper
import com.nookdev.uklontest.domain.model.Comment
import com.nookdev.uklontest.domain.model.Post
import com.nookdev.uklontest.domain.model.User
import com.nookdev.uklontest.domain.repository.DataRepository
import io.reactivex.Single
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val networkStateChecker: NetworkStateChecker,
    @LocalDataStoreQualifier private val localDataStore: DataStore,
    @RemoteDataStoreQualifier private val remoteDataStore: DataStore,
    private val postMapper: PostMapper,
    private val commentMapper: CommentMapper,
    private val userMapper: UserMapper
) : DataRepository {

    override fun getPosts(): Single<List<Post>> {
        return pickDataSource()
            .getPosts()
            .doOnSuccess {
                localDataStore.savePosts(it)
            }
            .map { postMapper.mapAll(it) }

    }

    override fun getComments(postId: Int): Single<List<Comment>> {
        return pickDataSource()
            .getCommentsByPost(postId)
            .doOnSuccess {
                localDataStore.saveComments(it)
            }
            .map { commentMapper.mapAll(it) }
    }

    override fun getUserById(userId: Int): Single<User> {
        return pickDataSource()
            .getUserById(userId)
            .doOnSuccess {
                localDataStore.saveUser(it)
            }
            .map { userMapper.map(it) }
    }

    fun pickDataSource(): DataStore {
        return if (networkStateChecker.isConnected()) {
            remoteDataStore
        } else {
            localDataStore
        }
    }

}
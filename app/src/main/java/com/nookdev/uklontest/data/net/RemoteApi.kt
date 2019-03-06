package com.nookdev.uklontest.data.net

import com.nookdev.uklontest.data.net.model.CommentApiModel
import com.nookdev.uklontest.data.net.model.PostApiModel
import com.nookdev.uklontest.data.net.model.UserApiModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApi {
    @GET("posts")
    fun getPosts(): Single<List<PostApiModel>>

    @GET("posts/{postId}/comments")
    fun getCommentsByPost(@Path("postId") postId: Int): Single<List<CommentApiModel>>

    @GET("users/{userId}")
    fun getUserById(@Path("userId") userId: Int): Single<UserApiModel>

}
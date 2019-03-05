package com.nookdev.uklontest.data.net

import com.nookdev.uklontest.data.net.model.CommentApiModel
import com.nookdev.uklontest.data.net.model.PostApiModel
import com.nookdev.uklontest.data.net.model.UserApiModel
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteApi {
    @GET("posts")
    fun getPosts(): Single<List<PostApiModel>>

    @GET("posts/{postId}/comments}")
    fun getCommentsByPost(postId: Int): Single<List<CommentApiModel>>

    @GET("users")
    fun getUserById(userId: Int): Single<UserApiModel>

}
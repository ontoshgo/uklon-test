package com.nookdev.uklontest.data.net.model

import com.google.gson.annotations.SerializedName

data class CommentApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("postId") val postId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("body") val body: String,
    @SerializedName("email") val email: String
)
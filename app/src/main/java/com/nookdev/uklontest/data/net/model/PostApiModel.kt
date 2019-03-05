package com.nookdev.uklontest.data.net.model

import com.google.gson.annotations.SerializedName

data class PostApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("userId") val userId: Int,
    @SerializedName("title") val title: String
)
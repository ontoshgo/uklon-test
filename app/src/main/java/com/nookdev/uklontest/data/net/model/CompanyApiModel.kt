package com.nookdev.uklontest.data.net.model

import com.google.gson.annotations.SerializedName

data class CompanyApiModel(
    @SerializedName("name") val name: String,
    @SerializedName("catchPhrase") val catchPhrase: String,
    @SerializedName("bs") val bs: String
)
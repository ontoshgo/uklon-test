package com.nookdev.uklontest.data.net.model

import com.google.gson.annotations.SerializedName

data class UserApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("adress") val address: AddressApiModel,
    @SerializedName("phone") val phone: String,
    @SerializedName("website") val webSite: String,
    @SerializedName("company") val company: CompanyApiModel
)
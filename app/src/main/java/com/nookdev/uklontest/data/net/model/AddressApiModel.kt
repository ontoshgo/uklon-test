package com.nookdev.uklontest.data.net.model

import com.google.gson.annotations.SerializedName

data class AddressApiModel(
    @SerializedName("street") val street: String,
    @SerializedName("suite") val suite: String,
    @SerializedName("city") val city: String,
    @SerializedName("zipcode") val zipCode: String,
    @SerializedName("geo") val geo: GeoApiModel
)
package com.nookdev.uklontest.data.net.model

import com.google.gson.annotations.SerializedName

data class GeoApiModel(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double
)
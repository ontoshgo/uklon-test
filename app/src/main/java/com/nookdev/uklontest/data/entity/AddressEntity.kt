package com.nookdev.uklontest.data.entity

data class AddressEntity(
    val street: String,
    val suite: String,
    val city: String,
    val zipCode: String,
    val geo: GeoEntity
)
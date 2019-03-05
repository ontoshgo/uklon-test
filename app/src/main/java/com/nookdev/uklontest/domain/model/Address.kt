package com.nookdev.uklontest.domain.model

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipCode: String,
    val geo: Geo
)
package com.nookdev.uklontest.domain.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val address: Address,
    val phone: String,
    val webSite: String,
    val company: Company
)
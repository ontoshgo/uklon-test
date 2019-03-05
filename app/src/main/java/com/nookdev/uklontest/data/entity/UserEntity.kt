package com.nookdev.uklontest.data.entity

data class UserEntity(
    val id: Int,
    val name: String,
    val username: String,
    val address: AddressEntity,
    val phone: String,
    val webSite: String,
    val company: CompanyEntity
)
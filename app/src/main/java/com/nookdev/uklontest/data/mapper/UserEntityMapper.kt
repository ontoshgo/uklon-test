package com.nookdev.uklontest.data.mapper

import com.nookdev.uklontest.data.entity.UserEntity
import com.nookdev.uklontest.data.net.model.UserApiModel
import javax.inject.Inject

class UserEntityMapper @Inject constructor(
    private val companyEntityMapper: CompanyEntityMapper,
    private val addressEntityMapper: AddressEntityMapper
) : Mapper<UserApiModel, UserEntity> {
    override fun map(input: UserApiModel): UserEntity {
        return input.run {
            UserEntity(
                id = id,
                name = name,
                username = username,
                address = addressEntityMapper.map(address),
                phone = phone,
                webSite = webSite,
                company = companyEntityMapper.map(company)
            )
        }
    }

    override fun reverse(output: UserEntity): UserApiModel {
        return output.run {
            UserApiModel(
                id = id,
                name = name,
                username = username,
                address = addressEntityMapper.reverse(address),
                phone = phone,
                webSite = webSite,
                company = companyEntityMapper.reverse(company)
            )
        }
    }

}
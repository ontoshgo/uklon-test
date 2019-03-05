package com.nookdev.uklontest.domain.mapper

import com.nookdev.uklontest.data.entity.UserEntity
import com.nookdev.uklontest.data.mapper.Mapper
import com.nookdev.uklontest.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor(
    private val companyEntityMapper: CompanyMapper,
    private val addressEntityMapper: AddressMapper
) : Mapper<UserEntity, User> {
    override fun map(input: UserEntity): User {
        return input.run {
            User(
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

    override fun reverse(output: User): UserEntity {
        return output.run {
            UserEntity(
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
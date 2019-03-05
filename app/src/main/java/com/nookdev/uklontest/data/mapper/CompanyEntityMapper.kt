package com.nookdev.uklontest.data.mapper

import com.nookdev.uklontest.data.entity.CompanyEntity
import com.nookdev.uklontest.data.net.model.CompanyApiModel
import javax.inject.Inject

class CompanyEntityMapper @Inject constructor() : Mapper<CompanyApiModel, CompanyEntity> {
    override fun map(input: CompanyApiModel): CompanyEntity {
        return input.run {
            CompanyEntity(
                name = name,
                catchPhrase = catchPhrase,
                bs = bs
            )
        }
    }

    override fun reverse(output: CompanyEntity): CompanyApiModel {
        return output.run {
            CompanyApiModel(
                name = name,
                catchPhrase = catchPhrase,
                bs = bs
            )
        }
    }

}
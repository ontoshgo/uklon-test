package com.nookdev.uklontest.domain.mapper

import com.nookdev.uklontest.data.entity.CompanyEntity
import com.nookdev.uklontest.data.mapper.Mapper
import com.nookdev.uklontest.domain.model.Company
import javax.inject.Inject

class CompanyMapper @Inject constructor() : Mapper<CompanyEntity, Company> {
    override fun map(input: CompanyEntity): Company {
        return input.run {
            Company(
                name = name,
                catchPhrase = catchPhrase,
                bs = bs
            )
        }
    }

    override fun reverse(output: Company): CompanyEntity {
        return output.run {
            CompanyEntity(
                name = name,
                catchPhrase = catchPhrase,
                bs = bs
            )
        }
    }

}
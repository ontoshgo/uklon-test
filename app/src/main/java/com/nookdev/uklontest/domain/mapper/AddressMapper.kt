package com.nookdev.uklontest.domain.mapper

import com.nookdev.uklontest.data.entity.AddressEntity
import com.nookdev.uklontest.data.mapper.Mapper
import com.nookdev.uklontest.domain.model.Address
import javax.inject.Inject

class AddressMapper @Inject constructor(
    private val geoEntityMapper: GeoMapper
) : Mapper<AddressEntity, Address> {
    override fun map(input: AddressEntity): Address {
        return input.run {
            Address(
                street = street,
                suite = suite,
                zipCode = zipCode,
                city = city,
                geo = geoEntityMapper.map(geo)
            )
        }
    }

    override fun reverse(output: Address): AddressEntity {
        return output.run {
            AddressEntity(
                street = street,
                suite = suite,
                zipCode = zipCode,
                city = city,
                geo = geoEntityMapper.reverse(geo)
            )
        }
    }

}
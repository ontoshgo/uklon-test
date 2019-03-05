package com.nookdev.uklontest.data.mapper

import com.nookdev.uklontest.data.entity.AddressEntity
import com.nookdev.uklontest.data.net.model.AddressApiModel
import javax.inject.Inject

class AddressEntityMapper @Inject constructor(
    private val geoEntityMapper: GeoEntityMapper
) : Mapper<AddressApiModel, AddressEntity> {
    override fun map(input: AddressApiModel): AddressEntity {
        return input.run {
            AddressEntity(
                street = street,
                suite = suite,
                zipCode = zipCode,
                city = city,
                geo = geoEntityMapper.map(geo)
            )
        }
    }

    override fun reverse(output: AddressEntity): AddressApiModel {
        return output.run {
            AddressApiModel(
                street = street,
                suite = suite,
                zipCode = zipCode,
                city = city,
                geo = geoEntityMapper.reverse(geo)
            )
        }
    }

}
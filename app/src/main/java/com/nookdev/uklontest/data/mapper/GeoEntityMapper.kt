package com.nookdev.uklontest.data.mapper

import com.nookdev.uklontest.data.entity.GeoEntity
import com.nookdev.uklontest.data.net.model.GeoApiModel
import javax.inject.Inject

class GeoEntityMapper @Inject constructor() : Mapper<GeoApiModel, GeoEntity> {
    override fun map(input: GeoApiModel): GeoEntity {
        return GeoEntity(input.lat, input.lon)
    }

    override fun reverse(output: GeoEntity): GeoApiModel {
        return GeoApiModel(output.lat, output.lon)
    }

}
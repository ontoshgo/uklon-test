package com.nookdev.uklontest.domain.mapper

import com.nookdev.uklontest.data.entity.GeoEntity
import com.nookdev.uklontest.data.mapper.Mapper
import com.nookdev.uklontest.domain.model.Geo
import javax.inject.Inject

class GeoMapper @Inject constructor() : Mapper<GeoEntity, Geo> {
    override fun map(input: GeoEntity): Geo {
        return Geo(input.lat, input.lon)
    }

    override fun reverse(output: Geo): GeoEntity {
        return GeoEntity(output.lat, output.lon)
    }

}
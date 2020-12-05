package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.NetworkData
import com.schaefer.mymovies.domain.model.NetworkDomain

class NetworkDomainMapper(private val countryDomainMapper: CountryDomainMapper) :
    Mapper<NetworkData, NetworkDomain> {

    override fun map(source: NetworkData): NetworkDomain {
        return NetworkDomain(
            id = source.id,
            name = source.name,
            countryDomain = countryDomainMapper.map(source.countryData)
        )
    }

}
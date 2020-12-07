package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.Network
import com.schaefer.mymovies.domain.model.NetworkDomain

class NetworkDomainMapper(private val countryDomainMapper: CountryDomainMapper) :
    Mapper<Network, NetworkDomain> {

    override fun map(source: Network): NetworkDomain {
        return NetworkDomain(
            id = source.id ?: 0,
            name = source.name.orEmpty(),
            countryDomain = source.country?.let { countryDomainMapper.map(source.country) }
        )
    }

}
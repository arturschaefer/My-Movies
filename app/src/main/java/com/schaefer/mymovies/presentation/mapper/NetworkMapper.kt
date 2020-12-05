package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.domain.model.NetworkDomain
import com.schaefer.mymovies.presentation.model.Network

class NetworkMapper(private val countryMapper: CountryMapper) :
    Mapper<NetworkDomain, Network> {

    override fun map(source: NetworkDomain): Network {
        return Network(
            id = source.id,
            name = source.name,
            country = source.countryDomain?.let { countryMapper.map(it) }
        )
    }

}
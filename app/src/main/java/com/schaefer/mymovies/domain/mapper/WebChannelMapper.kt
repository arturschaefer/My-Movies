package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.WebChannel
import com.schaefer.mymovies.domain.model.WebChannelDomain

class WebChannelMapper(private val countryDomainMapper: CountryDomainMapper) :
    Mapper<WebChannel, WebChannelDomain> {

    override fun map(source: WebChannel): WebChannelDomain {
        return WebChannelDomain(
            id = source.id ?: 0,
            name = source.name.orEmpty(),
            countryDomain = source.country?.let { countryDomainMapper.map(it) }
        )
    }
}
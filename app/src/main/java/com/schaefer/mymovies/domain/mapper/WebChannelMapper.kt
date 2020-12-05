package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.WebChannelData
import com.schaefer.mymovies.domain.model.WebChannelDomain

class WebChannelMapper(private val countryDomainMapper: CountryDomainMapper) :
    Mapper<WebChannelData, WebChannelDomain> {

    override fun map(source: WebChannelData): WebChannelDomain {
        return WebChannelDomain(
            id = source.id,
            name = source.name,
            countryDomain = countryDomainMapper.map(source.countryData)
        )
    }
}
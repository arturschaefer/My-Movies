package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.WebChannelData
import com.schaefer.mymovies.domain.model.CountryDomain
import com.schaefer.mymovies.domain.model.WebChannelDomain
import com.schaefer.mymovies.presentation.model.WebChannel

class WebChannelMapper(private val countryMapper: CountryMapper) :
    Mapper<WebChannelDomain, WebChannel> {

    override fun map(source: WebChannelDomain): WebChannel {
        return WebChannel(
            id = source.id,
            name = source.name,
            country = countryMapper.map(source.countryDomain)
        )
    }
}
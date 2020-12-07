package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.ShowResponse
import com.schaefer.mymovies.domain.model.ListShowDomain

class ListDomainShowMapper(val domainMapper: ShowDomainMapper) :
    Mapper<ShowResponse, ListShowDomain> {
    override fun map(source: ShowResponse): ListShowDomain {
        return ListShowDomain(
            listShowDomain = source.map { domainMapper.map(it) }
        )
    }
}
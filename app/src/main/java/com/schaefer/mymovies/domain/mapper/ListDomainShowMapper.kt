package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.ListShowData
import com.schaefer.mymovies.domain.model.ListShowDomain

class ListDomainShowMapper(val domainMapper: ShowDomainMapper) :
    Mapper<ListShowData, ListShowDomain> {
    override fun map(source: ListShowData): ListShowDomain {
        return ListShowDomain(
            listShowDomain = source.listShows.map { domainMapper.map(it) }
        )
    }
}
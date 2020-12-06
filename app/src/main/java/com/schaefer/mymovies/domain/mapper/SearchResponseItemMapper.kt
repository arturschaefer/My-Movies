package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.SearchResponse
import com.schaefer.mymovies.domain.model.ListShowDomain

class SearchResponseItemMapper(private val showMapper: ShowDomainMapper) :
    Mapper<SearchResponse, ListShowDomain> {
    override fun map(source: SearchResponse): ListShowDomain {
        return ListShowDomain(
            listShowDomain = source.map { showMapper.map(it.show) }
        )
    }
}
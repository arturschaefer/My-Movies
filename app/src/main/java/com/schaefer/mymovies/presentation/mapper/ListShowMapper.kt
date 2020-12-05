package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.ListShowData
import com.schaefer.mymovies.domain.model.ListShowDomain
import com.schaefer.mymovies.presentation.model.ListShow

class ListShowMapper(val mapper: ShowMapper) :
    Mapper<ListShowDomain, ListShow> {
    override fun map(source: ListShowDomain): ListShow {
        return ListShow(
            listShow = source.listShowDomain.map { mapper.map(it) }
        )
    }
}
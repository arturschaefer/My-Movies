package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.RatingData
import com.schaefer.mymovies.domain.model.RatingDomain

class RatingDomainMapper: Mapper<RatingData, RatingDomain> {
    override fun map(source: RatingData): RatingDomain {
        return RatingDomain(
            average = source.average
        )
    }
}
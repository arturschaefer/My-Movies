package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.Rating
import com.schaefer.mymovies.domain.model.RatingDomain

class RatingDomainMapper: Mapper<Rating, RatingDomain> {
    override fun map(source: Rating): RatingDomain {
        return RatingDomain(
            average = source.average ?: 0.0
        )
    }
}
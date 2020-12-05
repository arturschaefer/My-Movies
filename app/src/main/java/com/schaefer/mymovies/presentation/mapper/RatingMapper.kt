package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.RatingData
import com.schaefer.mymovies.domain.model.RatingDomain
import com.schaefer.mymovies.presentation.model.Rating

class RatingMapper : Mapper<RatingDomain, Rating> {
    override fun map(source: RatingDomain): Rating {
        return Rating(
            average = source.average
        )
    }
}
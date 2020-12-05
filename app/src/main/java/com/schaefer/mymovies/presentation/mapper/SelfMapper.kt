package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.SelfData
import com.schaefer.mymovies.domain.model.SelfDomain
import com.schaefer.mymovies.presentation.model.Self

class SelfMapper: Mapper<SelfDomain, Self> {
    override fun map(source: SelfDomain): Self {
        return Self(source.href)
    }
}
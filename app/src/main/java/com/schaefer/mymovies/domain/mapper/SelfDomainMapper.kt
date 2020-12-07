package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.Self
import com.schaefer.mymovies.domain.model.SelfDomain

class SelfDomainMapper: Mapper<Self, SelfDomain> {
    override fun map(source: Self): SelfDomain {
        return SelfDomain(source.href.orEmpty())
    }
}
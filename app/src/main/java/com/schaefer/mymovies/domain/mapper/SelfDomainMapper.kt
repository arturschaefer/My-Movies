package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.SelfData
import com.schaefer.mymovies.domain.model.SelfDomain

class SelfDomainMapper: Mapper<SelfData, SelfDomain> {
    override fun map(source: SelfData): SelfDomain {
        return SelfDomain(source.href)
    }
}
package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.CountryData
import com.schaefer.mymovies.domain.model.CountryDomain

class CountryDomainMapper: Mapper<CountryData, CountryDomain> {
    override fun map(source: CountryData): CountryDomain {
        return CountryDomain(
            name = source.name,
            code  = source.code,
            timezone  = source.timezone,
        )
    }

}

package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.Country
import com.schaefer.mymovies.domain.model.CountryDomain

class CountryDomainMapper: Mapper<Country, CountryDomain> {
    override fun map(source: Country): CountryDomain {
        return CountryDomain(
            name = source.name,
            code  = source.code,
            timezone  = source.timezone,
        )
    }

}

package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.domain.model.CountryDomain
import com.schaefer.mymovies.presentation.model.Country

class CountryMapper: Mapper<CountryDomain, Country> {
    override fun map(source: CountryDomain): Country {
        return Country(
            name = source.name,
            code  = source.code,
            timezone  = source.timezone,
        )
    }

}

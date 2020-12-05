package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.Schedule
import com.schaefer.mymovies.domain.model.ScheduleDomain

class ScheduleDomainMapper : Mapper<Schedule, ScheduleDomain> {
    override fun map(source: Schedule): ScheduleDomain {
        return ScheduleDomain(
            time = source.time.orEmpty(),
            days = source.days ?: emptyList()
        )
    }
}
package com.schaefer.mymovies.domain.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.model.ScheduleData
import com.schaefer.mymovies.domain.model.ScheduleDomain

class ScheduleDomainMapper : Mapper<ScheduleData, ScheduleDomain> {
    override fun map(source: ScheduleData): ScheduleDomain {
        return ScheduleDomain(
            time = source.time,
            days = source.days
        )
    }
}
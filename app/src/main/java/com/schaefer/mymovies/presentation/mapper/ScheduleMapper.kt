package com.schaefer.mymovies.presentation.mapper

import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.domain.model.ScheduleDomain
import com.schaefer.mymovies.presentation.model.Schedule

class ScheduleMapper : Mapper<ScheduleDomain, Schedule> {
    override fun map(source: ScheduleDomain): Schedule {
        return Schedule(
            time = source.time,
            days = source.days
        )
    }
}
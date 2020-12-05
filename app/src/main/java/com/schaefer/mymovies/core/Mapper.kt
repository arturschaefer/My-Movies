package com.schaefer.mymovies.core

import com.schaefer.mymovies.data.model.ShowData

interface Mapper<S, T> {
    fun map(source: S): T
}
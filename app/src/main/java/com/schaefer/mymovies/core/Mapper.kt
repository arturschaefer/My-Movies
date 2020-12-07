package com.schaefer.mymovies.core

interface Mapper<S, T> {
    fun map(source: S): T
}
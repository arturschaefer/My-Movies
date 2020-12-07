package com.schaefer.mymovies.domain.repository

import com.schaefer.mymovies.domain.model.ListShowDomain
import io.reactivex.rxjava3.core.Single

interface ShowsRepository {
    fun getShows(page: Int): Single<ListShowDomain>
    fun getSearchShows(search: String): Single<ListShowDomain>
}
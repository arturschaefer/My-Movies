package com.schaefer.mymovies.domain.repository

import androidx.paging.PagingData
import com.schaefer.mymovies.domain.model.ListShowDomain
import com.schaefer.mymovies.domain.model.ShowDomain
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single

interface ShowsRepository {
    fun getShows(page: Int): Flowable<PagingData<ShowDomain>>

    fun getSearchShows(search: String): Single<ListShowDomain>
}
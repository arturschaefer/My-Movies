package com.schaefer.mymovies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.flowable
import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.api.TvMazeAPI
import com.schaefer.mymovies.data.model.SearchResponse
import com.schaefer.mymovies.data.paging.GetShowsPagingDataSource
import com.schaefer.mymovies.domain.model.ListShowDomain
import com.schaefer.mymovies.domain.model.ShowDomain
import com.schaefer.mymovies.domain.repository.ShowsRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ShowsRepositoryImpl @Inject constructor(
    private val service: TvMazeAPI,
    private val mapperSearch: Mapper<SearchResponse, ListShowDomain>,
    private val pagingSource: GetShowsPagingDataSource
) : ShowsRepository {

    override fun getShows(page: Int): Flowable<PagingData<ShowDomain>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 40),
            pagingSourceFactory = { pagingSource }
        ).flowable
    }

    override fun getSearchShows(search: String): Single<ListShowDomain> {
        return service.getSearchShows(search).map { response ->
            mapperSearch.map(response)
        }
    }
}
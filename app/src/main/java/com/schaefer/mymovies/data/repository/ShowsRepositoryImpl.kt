package com.schaefer.mymovies.data.repository

import com.schaefer.mymovies.data.api.TvMazeAPI
import com.schaefer.mymovies.domain.mapper.ListDomainShowMapper
import com.schaefer.mymovies.domain.model.ListShowDomain
import com.schaefer.mymovies.domain.repository.ShowsRepository
import io.reactivex.rxjava3.core.Single
import kotlinx.serialization.ExperimentalSerializationApi
import timber.log.Timber
import javax.inject.Inject

@ExperimentalSerializationApi
class ShowsRepositoryImpl @Inject constructor(
    private val service: TvMazeAPI,
    private val mapperDomain: ListDomainShowMapper
) : ShowsRepository {
    override fun getShows(page: Int): Single<ListShowDomain> {
        return service.getShowsByPage(page).map { response ->
            Timber.d(response.toString())
            mapperDomain.map(response)
        }
    }

}
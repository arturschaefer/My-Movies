package com.schaefer.mymovies.domain.usecase

import com.schaefer.mymovies.domain.repository.ShowsRepository
import com.schaefer.mymovies.presentation.mapper.ListShowMapper
import com.schaefer.mymovies.presentation.model.ListShow
import io.reactivex.rxjava3.core.Single

class GetSearchShowsUseCase(private val repository: ShowsRepository, private val mapper: ListShowMapper) {
    operator fun invoke(search: String): Single<ListShow> {
        return repository.getSearchShows(search).map {
            mapper.map(it)
        }
    }
}
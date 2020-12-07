package com.schaefer.mymovies.domain.usecase

import com.schaefer.mymovies.domain.repository.ShowsRepository
import com.schaefer.mymovies.presentation.mapper.ListShowMapper
import com.schaefer.mymovies.presentation.model.ListShow
import io.reactivex.rxjava3.core.Single

class GetShowsUseCase(private val repository: ShowsRepository, private val mapper: ListShowMapper) {
    operator fun invoke(page: Int): Single<ListShow> {
        return repository.getShows(page).map {
            mapper.map(it)
        }
    }
}
package com.schaefer.mymovies.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.schaefer.mymovies.domain.repository.ShowsRepository
import com.schaefer.mymovies.presentation.mapper.ShowMapper
import com.schaefer.mymovies.presentation.model.Show
import io.reactivex.rxjava3.core.Flowable

class GetShowsUseCase(private val repository: ShowsRepository, private val mapper: ShowMapper) {
    operator fun invoke(page: Int): Flowable<PagingData<Show>> {
        return repository.getShows(page).map { pagingData ->
            pagingData.map { mapper.map(it) }
        }
    }
}
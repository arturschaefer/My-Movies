package com.schaefer.mymovies.domain.usecase

import com.schaefer.mymovies.domain.repository.EpisodeRepository
import com.schaefer.mymovies.presentation.mapper.ListEpisodeMapper
import com.schaefer.mymovies.presentation.model.ListEpisode
import io.reactivex.rxjava3.core.Single

class GetEpisodeListUseCase(
    private val episodeRepository: EpisodeRepository,
    val mapper: ListEpisodeMapper
) {

    operator fun invoke(showId: Int): Single<ListEpisode> {
        return episodeRepository.getEpisodeList(showId).map {
            mapper.map(it)
        }
    }
}
package com.schaefer.mymovies.domain.repository

import com.schaefer.mymovies.domain.model.ListEpisodeDomain
import io.reactivex.rxjava3.core.Single

interface EpisodeRepository {
    fun getEpisodeList(showId: Int): Single<ListEpisodeDomain>
}
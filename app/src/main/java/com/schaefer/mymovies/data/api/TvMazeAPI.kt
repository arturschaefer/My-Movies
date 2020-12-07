package com.schaefer.mymovies.data.api

import com.schaefer.mymovies.data.model.EpisodeResponse
import com.schaefer.mymovies.data.model.SearchResponse
import com.schaefer.mymovies.data.model.ShowResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvMazeAPI {
    @GET("shows?")
    fun getShowsByPage(@Query("page") page: Int): Single<ShowResponse>

    @GET("search/shows?")
    fun getSearchShows(@Query("q") search: String): Single<SearchResponse>

    @GET("shows/{id}/episodes")
    fun getEpisodeList(@Path("id") showId: Int): Single<EpisodeResponse>
}
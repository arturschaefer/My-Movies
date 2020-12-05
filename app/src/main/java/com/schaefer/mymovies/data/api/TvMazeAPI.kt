package com.schaefer.mymovies.data.api

import com.schaefer.mymovies.data.model.ListShowData
import com.schaefer.mymovies.data.model.ShowData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TvMazeAPI {
    @GET("shows?")
    fun getShowsByPage(@Query("page") page: Int): Single<ListShowData>
}
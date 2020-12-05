package com.schaefer.mymovies.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.schaefer.mymovies.BuildConfig
import com.schaefer.mymovies.data.api.TvMazeAPI
import com.schaefer.mymovies.data.api.TvMazeServiceAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import timber.log.Timber
import javax.inject.Singleton

@ExperimentalSerializationApi
@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun providerRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit =
        TvMazeServiceAPI(okHttpClient).getService(gson)

    @Provides
    fun providesOkHttpClient(interceptor: Interceptor): OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(interceptor).build()

    @Provides
    fun providesInterceptor(): Interceptor = HttpLoggingInterceptor {
        Timber.tag("OkHttp").d(it)
    }.apply {
        level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    @Singleton
    @Provides
    fun getTvMazeAPI(retrofit: Retrofit): TvMazeAPI =
        retrofit.create(TvMazeAPI::class.java)
}
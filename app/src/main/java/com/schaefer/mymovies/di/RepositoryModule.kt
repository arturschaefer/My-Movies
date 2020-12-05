package com.schaefer.mymovies.di

import com.schaefer.mymovies.data.api.TvMazeAPI
import com.schaefer.mymovies.data.repository.ShowsRepositoryImpl
import com.schaefer.mymovies.domain.mapper.ListDomainShowMapper
import com.schaefer.mymovies.domain.repository.ShowsRepository
import com.schaefer.mymovies.domain.usecase.GetShowsUseCase
import com.schaefer.mymovies.presentation.mapper.ListShowMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {
    @Provides
    fun providesShowsRepository(
        service: TvMazeAPI,
        mapperDomain: ListDomainShowMapper
    ): ShowsRepository = ShowsRepositoryImpl(service, mapperDomain)

    @Provides
    fun providesGetShowUseCase(repository: ShowsRepository, mapper: ListShowMapper) =
        GetShowsUseCase(repository, mapper)
}
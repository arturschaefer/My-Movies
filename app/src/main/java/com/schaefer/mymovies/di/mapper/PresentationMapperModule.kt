package com.schaefer.mymovies.di.mapper

import com.schaefer.mymovies.presentation.mapper.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class PresentationMapperModule {
    @Provides
    fun providesScheduleMapper(): ScheduleMapper = ScheduleMapper()

    @Provides
    @Singleton
    fun providesRatingMapper(): RatingMapper = RatingMapper()

    @Provides
    fun providesNetworkMapper(mapper: CountryMapper): NetworkMapper =
        NetworkMapper(mapper)

    @Provides
    fun providesCountryMapper(): CountryMapper =
        CountryMapper()

    @Provides
    fun providesExternalsMapper(mapper: CountryMapper): WebChannelMapper =
        WebChannelMapper(mapper)

    @Provides
    fun providesWebChannelMapper(): ExternalsMapper = ExternalsMapper()

    @Provides
    fun providesImageMapper(): ImageMapper = ImageMapper()

    @Provides
    @Singleton
    fun providesPreviousEpisodeMapper(): PreviousEpisodeMapper = PreviousEpisodeMapper()

    @Provides
    fun providesSelfMapper(): SelfMapper = SelfMapper()

    @Provides
    fun providesLinksMapper(
        previousEpisodeMapper: PreviousEpisodeMapper,
        selfMapper: SelfMapper
    ): LinksMapper = LinksMapper(previousEpisodeMapper, selfMapper)

    @Provides
    fun providesShowDataMapper(
        scheduleMapper: ScheduleMapper,
        ratingMapper: RatingMapper,
        networkMapper: NetworkMapper,
        webChannelMapper: WebChannelMapper,
        externalsMapper: ExternalsMapper,
        imageMapper: ImageMapper,
        linksMapper: LinksMapper
    ): ShowMapper = ShowMapper(
        scheduleMapper,
        ratingMapper,
        networkMapper,
        webChannelMapper,
        externalsMapper,
        imageMapper,
        linksMapper
    )

    @Provides
    fun providesListShowDataMapper(mapper: ShowMapper): ListShowMapper =
        ListShowMapper(mapper)

    @Provides
    fun providesEpisodeItemMapper(
        mapperLinksMapper: LinksMapper,
        imageMapper: ImageMapper
    ): EpisodeMapper =
        EpisodeMapper(mapperLinksMapper, imageMapper)

    @Provides
    fun providesListEpisodeMapper(mapper: EpisodeMapper): ListEpisodeMapper =
        ListEpisodeMapper(mapper)
}
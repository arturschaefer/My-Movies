package com.schaefer.mymovies.di.mapper

import com.schaefer.mymovies.domain.mapper.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class DomainMapperModule {
    @Provides
    fun providesScheduleMapper(): ScheduleDomainMapper = ScheduleDomainMapper()

    @Provides
    fun providesRatingMapper(): RatingDomainMapper = RatingDomainMapper()

    @Provides
    fun providesNetworkMapper(domainMapper: CountryDomainMapper): NetworkDomainMapper =
        NetworkDomainMapper(domainMapper)

    @Provides
    fun providesCountryMapper(): CountryDomainMapper =
        CountryDomainMapper()

    @Provides
    fun providesExternalsMapper(domainMapper: CountryDomainMapper): WebChannelMapper =
        WebChannelMapper(domainMapper)

    @Provides
    fun providesWebChannelMapper(): ExternalsDomainMapper = ExternalsDomainMapper()

    @Provides
    fun providesImageMapper(): ImageDomainMapper = ImageDomainMapper()

    @Provides
    fun providesPreviousEpisodeMapper(): PreviousEpisodeDomainMapper = PreviousEpisodeDomainMapper()

    @Provides
    fun providesSelfMapper(): SelfDomainMapper = SelfDomainMapper()

    @Provides
    fun providesLinksMapper(
        previousEpisodeDomainMapper: PreviousEpisodeDomainMapper,
        selfDomainMapper: SelfDomainMapper
    ): LinksDomainMapper = LinksDomainMapper(previousEpisodeDomainMapper, selfDomainMapper)

    @Provides
    fun providesShowDataMapper(
        scheduleDomainMapper: ScheduleDomainMapper,
        ratingDomainMapper: RatingDomainMapper,
        networkDomainMapper: NetworkDomainMapper,
        webChannelMapper: WebChannelMapper,
        externalsDomainMapper: ExternalsDomainMapper,
        imageDomainMapper: ImageDomainMapper,
        linksDomainMapper: LinksDomainMapper
    ): ShowDomainMapper = ShowDomainMapper(
        scheduleDomainMapper,
        ratingDomainMapper,
        networkDomainMapper,
        webChannelMapper,
        externalsDomainMapper,
        imageDomainMapper,
        linksDomainMapper
    )

    @Provides
    fun providesListShowDataMapper(domainMapper: ShowDomainMapper): ListDomainShowMapper =
        ListDomainShowMapper(domainMapper)

    @Provides
    fun providesSearchDataMapper(domainMapper: ShowDomainMapper): SearchResponseItemMapper =
        SearchResponseItemMapper(domainMapper)

    @Provides
    fun providesEpisodeItemMapper(
        mapperLinksDomainMapper: LinksDomainMapper,
        imageDomainMapper: ImageDomainMapper
    ): EpisodeDomainMapper =
        EpisodeDomainMapper(mapperLinksDomainMapper, imageDomainMapper)

    @Provides
    fun providesListEpisodeMapper(mapper: EpisodeDomainMapper): ListEpisodeDomainMapper =
        ListEpisodeDomainMapper(mapper)
}
package com.schaefer.mymovies.data.repository

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.api.TvMazeAPI
import com.schaefer.mymovies.data.model.EpisodeResponse
import com.schaefer.mymovies.domain.model.ListEpisodeDomain
import com.schaefer.mymovies.dummy.EpisodeDummyResponse
import io.reactivex.rxjava3.core.Single
import org.junit.Test

class EpisodeRepositoryImplTest {

    private val service: TvMazeAPI = mock()
    private val episodeDomainMapper: Mapper<EpisodeResponse, ListEpisodeDomain> = mock()
    private val episodeRepository = EpisodeRepositoryImpl(service, episodeDomainMapper)

    @Test
    fun `getEpisodeList Should return a Show's list of episodes`() {
        //Given
        val showId = 1234
        val dummyResponse = EpisodeDummyResponse.getResponseFromJson()
        val dummyListEpisodeDomain = EpisodeDummyResponse.getListEpisodeDomainFromJson()

        whenever(service.getEpisodeList(any())).thenReturn(Single.just(dummyResponse))
        whenever(episodeDomainMapper.map(any())).thenReturn(dummyListEpisodeDomain)

        //When
        val result = episodeRepository.getEpisodeList(showId).test()

        //Then
        result.assertComplete().assertNoErrors().assertValue(dummyListEpisodeDomain)
        verify(service).getEpisodeList(showId)
        verify(episodeDomainMapper).map(dummyResponse)
    }

    @Test
    fun `getEpisodeList Should return a error from service`() {
        //Given
        val showId = 1234
        val genericError = Throwable()
        whenever(service.getEpisodeList(any())).thenReturn(Single.error(genericError))

        //When
        val result = episodeRepository.getEpisodeList(showId).test()

        //Then
        result.assertNotComplete().assertError(genericError)
        verify(service).getEpisodeList(showId)
    }
}
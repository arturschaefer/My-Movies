package com.schaefer.mymovies.data.repository

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.schaefer.mymovies.core.Mapper
import com.schaefer.mymovies.data.api.TvMazeAPI
import com.schaefer.mymovies.data.model.SearchResponse
import com.schaefer.mymovies.data.model.ShowResponse
import com.schaefer.mymovies.data.paging.GetShowsPagingDataSource
import com.schaefer.mymovies.domain.model.ListShowDomain
import com.schaefer.mymovies.dummy.ShowDummyResponse
import io.reactivex.rxjava3.core.Single
import org.junit.Test

class ShowsRepositoryImplTest {

    private val service: TvMazeAPI = mock()
    private val mapperSearch: Mapper<SearchResponse, ListShowDomain> = mock()
    private val mapperShow: Mapper<ShowResponse, ListShowDomain> = mock()

    private val pagingSource = GetShowsPagingDataSource(service, mapperShow)
    private val showRepository = ShowsRepositoryImpl(service, mapperSearch, pagingSource)

    @Test
    fun `getSearchShows Should return a list of Shows find by query`() {
        //Given
        val searchQuery = "Test"
        val dummyResponse = ShowDummyResponse.getSearchResponseFromJson()
        val dummyListShowDomain = ShowDummyResponse.getSearchListShowDomain()

        whenever(service.getSearchShows(searchQuery)).thenReturn(Single.just(dummyResponse))
        whenever(mapperSearch.map(any())).thenReturn(dummyListShowDomain)

        //When
        val result = showRepository.getSearchShows(searchQuery).test()

        //Then
        result.assertComplete().assertNoErrors().assertValue(dummyListShowDomain)
        verify(service).getSearchShows(searchQuery)
        verify(mapperSearch).map(dummyResponse)
    }

    @Test
    fun `getSearchShows Should return a error from service`() {
        //Given
        val searchQuery = "Test"
        val genericError = Throwable()
        whenever(service.getSearchShows(any())).thenReturn(Single.error(genericError))

        //When
        val result = showRepository.getSearchShows(searchQuery).test()

        //Then
        result.assertNotComplete().assertError(genericError)
        verify(service).getSearchShows(searchQuery)
    }

    //TODO create tests to getShows
//    @Test
//    fun `getShows Should return show list`(){
//        //Given
//        val page = 1
//        val dummyResponse = ShowDummyResponse.getShowListResponse()
//        val dummyListShowDomain = ShowDummyResponse.getSearchListShowDomain()
//
//        val onSuccess: Consumer<PagingSource.LoadResult<Int, ShowDomain>> = mock()
//        val onError: Consumer<Throwable> = mock()
//        val params: PagingSource.LoadParams<Int> = mock()
//
//        whenever(service.getShowsByPage(any())).thenReturn(Single.just(dummyResponse))
//        pagingSource.loadSingle(params).subscribe(onSuccess, onError)
//
//        //When
//        val result = showRepository.getShows(page).test()
//
//        //Then
//        result.assertComplete().assertNoErrors()
//        verify(service).getShowsByPage(page)
//    }
}
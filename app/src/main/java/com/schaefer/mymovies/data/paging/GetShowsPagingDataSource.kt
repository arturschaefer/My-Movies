package com.schaefer.mymovies.data.paging

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.schaefer.mymovies.data.api.TvMazeAPI
import com.schaefer.mymovies.domain.mapper.ListDomainShowMapper
import com.schaefer.mymovies.domain.model.ListShowDomain
import com.schaefer.mymovies.domain.model.ShowDomain
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

//Reference https://medium.com/@fandygotama/paging-3-using-rxjava-3ddc218e4dba
class GetShowsPagingDataSource(
    private val service: TvMazeAPI,
    private val mapper: ListDomainShowMapper
) :
    RxPagingSource<Int, ShowDomain>() {

    //TODO create e mediator PagingSource with Room

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, ShowDomain>> {
        val position = params.key ?: 1

        return service.getShowsByPage(position)
            .subscribeOn(Schedulers.io())
            .map { mapper.map(it) }
            .map { toLoadResult(it, position) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(data: ListShowDomain, position: Int): LoadResult<Int, ShowDomain> {
        return LoadResult.Page(
            data = data.listShowDomain,
            prevKey = if (position == 1) null else position - 1,
            nextKey = if (position == data.listShowDomain.size) null else position + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, ShowDomain>): Int? {
        return state.anchorPosition
    }
}
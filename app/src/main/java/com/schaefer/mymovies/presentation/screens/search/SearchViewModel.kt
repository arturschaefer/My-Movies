package com.schaefer.mymovies.presentation.screens.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.schaefer.mymovies.core.viewmodel.ViewModel
import com.schaefer.mymovies.domain.usecase.GetSearchShowsUseCase
import com.schaefer.mymovies.presentation.model.ListShow
import com.schaefer.mymovies.presentation.model.Show
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class SearchViewModel @ViewModelInject constructor(
    val getSearchShowsUseCase: GetSearchShowsUseCase
) : ViewModel<SearchViewState, SearchAction>(SearchViewState()) {

    private val mutableListShow = MutableLiveData<ListShow>()
    val listShow: LiveData<ListShow> = mutableListShow

    fun getShowsBySearch(search: String?) {
        search?.let {
            getSearchShowsUseCase(search).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { showLoading() }
                .doFinally { hideLoading() }
                .subscribe(::getShowsSuccess, ::getShowsError)
                .handleDisposable()
        }
    }

    private fun getShowsError(throwable: Throwable?) {
        Timber.d("Error $throwable")
    }

    private fun hideLoading() {
        setState(SearchViewState(false).isLoadingEnabled(false))
    }

    private fun showLoading() {
        setState(SearchViewState(false).isLoadingEnabled(true))
    }

    private fun getShowsSuccess(listShow: ListShow) {
        mutableListShow.value = listShow
        setState(SearchViewState(false))
    }

    fun navigateToDetails(show: Show) {
        sendAction(SearchAction.NavigateToDetails(show))
    }

}
package com.schaefer.mymovies.presentation.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.schaefer.mymovies.core.viewmodel.ViewModel
import com.schaefer.mymovies.domain.usecase.GetSearchShowsUseCase
import com.schaefer.mymovies.domain.usecase.GetShowsUseCase
import com.schaefer.mymovies.presentation.model.ListShow
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class HomeViewModel @ViewModelInject constructor(
    private val getShowsUseCase: GetShowsUseCase,
    private val getSearchShowsUseCase: GetSearchShowsUseCase
) :
    ViewModel<HomeViewState, HomeAction>(HomeViewState(true)) {

    private val mutableListShow = MutableLiveData<ListShow>()
    val listShow: LiveData<ListShow> = mutableListShow

    fun getShows(page: Int = 1) {
        //TODO get the correct page
        getShowsUseCase(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading() }
            .doFinally { hideLoading() }
            .subscribe(::getShowsSuccess, ::getShowsError)
            .handleDisposable()
    }

    private fun getShowsError(throwable: Throwable?) {
        Timber.d("Error $throwable")
    }

    private fun hideLoading() {
        setState(HomeViewState().isLoadingEnabled(false))
    }

    private fun showLoading() {
        setState(HomeViewState().isLoadingEnabled(true))
    }

    private fun getShowsSuccess(listShow: ListShow) {
        mutableListShow.value = listShow
    }

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
}
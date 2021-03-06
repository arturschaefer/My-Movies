package com.schaefer.mymovies.presentation.screens.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import com.schaefer.mymovies.core.viewmodel.ViewModel
import com.schaefer.mymovies.domain.usecase.GetShowsUseCase
import com.schaefer.mymovies.presentation.model.Show
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class HomeViewModel @ViewModelInject constructor(
    private val getShowsUseCase: GetShowsUseCase
) :
    ViewModel<HomeViewState, HomeAction>(HomeViewState(true)) {

    private val mutableListShow = MutableLiveData<PagingData<Show>>()
    val listShow: LiveData<PagingData<Show>> = mutableListShow

    fun getShows(page: Int = 1) {
        getShowsUseCase(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
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

    private fun getShowsSuccess(listShow: PagingData<Show>) {
        mutableListShow.value = listShow
    }

    fun navigateToDetails(show: Show) {
        sendAction(HomeAction.NavigateToDetails(show))
    }

    fun navigateToSearch(){
        sendAction(HomeAction.NavigateToSearch)
    }
}
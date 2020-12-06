package com.schaefer.mymovies.presentation.showdetails

import androidx.hilt.lifecycle.ViewModelInject
import com.schaefer.mymovies.core.viewmodel.ViewModel
import com.schaefer.mymovies.domain.usecase.GetEpisodeListUseCase
import com.schaefer.mymovies.presentation.model.ListEpisode
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class ShowDetailsViewModel @ViewModelInject constructor(val getEpisodeListUseCase: GetEpisodeListUseCase) :
    ViewModel<ShowDetailsViewState, ShowDetailAction>(ShowDetailsViewState(true)) {

    fun getEpisodeList(showId: Int) {
        getEpisodeListUseCase(showId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading() }
            .doFinally { hideLoading() }
            .subscribe(::getEpisodesSuccess, ::getEpisodesError)
            .handleDisposable()
    }

    private fun getEpisodesError(throwable: Throwable?) {
        Timber.e(throwable)
    }

    private fun getEpisodesSuccess(listEpisode: ListEpisode) {
        Timber.d(listEpisode.toString())
    }

    private fun hideLoading() {
//        TODO("Not yet implemented")
    }

    private fun showLoading() {
//        TODO("Not yet implemented")
    }
}
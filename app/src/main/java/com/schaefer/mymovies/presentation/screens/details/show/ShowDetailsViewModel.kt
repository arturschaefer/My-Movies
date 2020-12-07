package com.schaefer.mymovies.presentation.screens.details.show

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.schaefer.mymovies.core.viewmodel.ViewModel
import com.schaefer.mymovies.domain.usecase.GetEpisodeListUseCase
import com.schaefer.mymovies.presentation.model.Episode
import com.schaefer.mymovies.presentation.model.ListEpisode
import com.schaefer.mymovies.presentation.model.Show
import com.schaefer.mymovies.presentation.screens.details.DetailsAction
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class ShowDetailsViewModel @ViewModelInject constructor(val getEpisodeListUseCase: GetEpisodeListUseCase) :
    ViewModel<ShowDetailsViewState, DetailsAction>(ShowDetailsViewState(true)) {

    var show: Show? = null

    private val mutableHashMap = MutableLiveData<Map<Int?, List<Episode>>>()
    val episodes: LiveData<Map<Int?, List<Episode>>> = mutableHashMap

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
        mutableHashMap.value = listEpisode.listOfEpisodes.groupBy { it.season }
    }

    private fun hideLoading() {
//        TODO("Not yet implemented")
    }

    private fun showLoading() {
//        TODO("Not yet implemented")
    }

    fun navigateToShowDetails() {
        sendAction(DetailsAction.NavigateToShowDetails)
    }

    fun navigateToEpisodeDetails(episode: Episode) {
        sendAction(DetailsAction.NavigateToEpisodeDetails(episode))
    }
}
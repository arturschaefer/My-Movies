package com.schaefer.mymovies.presentation.screens.details.show

import com.schaefer.mymovies.core.viewmodel.UIState

data class ShowDetailsViewState(val isLoadingEpisodes: Boolean) : UIState {
    fun isLoadingEpisodesList(isLoading: Boolean) = this.copy(isLoading)
}

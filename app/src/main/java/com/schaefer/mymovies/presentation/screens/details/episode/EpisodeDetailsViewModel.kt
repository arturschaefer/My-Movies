package com.schaefer.mymovies.presentation.screens.details.episode

import androidx.hilt.lifecycle.ViewModelInject
import com.schaefer.mymovies.core.viewmodel.ViewModel
import com.schaefer.mymovies.presentation.model.Episode
import com.schaefer.mymovies.presentation.screens.details.DetailsAction

class EpisodeDetailsViewModel @ViewModelInject constructor() :
    ViewModel<EpisodeViewState, DetailsAction>(EpisodeViewState(true)) {

    fun navigateToShowDetails() {
        sendAction(DetailsAction.NavigateToShowDetails)
    }

    var episode: Episode? = null
}
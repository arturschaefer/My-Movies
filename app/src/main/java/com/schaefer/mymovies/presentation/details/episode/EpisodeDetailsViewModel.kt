package com.schaefer.mymovies.presentation.details.episode

import androidx.hilt.lifecycle.ViewModelInject
import com.schaefer.mymovies.core.viewmodel.ViewModel
import com.schaefer.mymovies.presentation.details.DetailsAction
import com.schaefer.mymovies.presentation.model.Episode

class EpisodeDetailsViewModel @ViewModelInject constructor() :
    ViewModel<EpisodeViewState, DetailsAction>(EpisodeViewState(true)) {

    fun navigateToShowDetails() {
        sendAction(DetailsAction.NavigateToShowDetails)
    }

    var episode: Episode? = null
}
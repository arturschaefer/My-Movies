package com.schaefer.mymovies.presentation.details.show

import com.schaefer.mymovies.core.viewmodel.UIAction
import com.schaefer.mymovies.presentation.model.Episode

sealed class ShowDetailsAction : UIAction {
    data class NavigateToEpisodeDetails(val episode: Episode): ShowDetailsAction()
}

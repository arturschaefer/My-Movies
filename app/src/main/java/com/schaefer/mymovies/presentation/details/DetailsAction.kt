package com.schaefer.mymovies.presentation.details

import com.schaefer.mymovies.core.viewmodel.UIAction
import com.schaefer.mymovies.presentation.model.Episode

sealed class DetailsAction : UIAction {
    object NavigateToShowDetails : DetailsAction()
    data class NavigateToEpisodeDetails(val episode: Episode): DetailsAction()
}

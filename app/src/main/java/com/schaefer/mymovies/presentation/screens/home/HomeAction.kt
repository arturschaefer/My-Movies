package com.schaefer.mymovies.presentation.screens.home

import com.schaefer.mymovies.core.viewmodel.UIAction
import com.schaefer.mymovies.presentation.model.Show

sealed class HomeAction: UIAction {
    data class NavigateToDetails(val show: Show): HomeAction()
    data class FavoriteMovie(val show: Show): HomeAction()
    object NavigateToSearch: HomeAction()
}
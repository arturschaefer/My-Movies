package com.schaefer.mymovies.presentation.screens.search

import com.schaefer.mymovies.core.viewmodel.UIAction
import com.schaefer.mymovies.presentation.model.Show

sealed class SearchAction: UIAction{
    data class NavigateToDetails(val show: Show): SearchAction()
}

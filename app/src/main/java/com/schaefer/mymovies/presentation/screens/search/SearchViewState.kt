package com.schaefer.mymovies.presentation.screens.search

import com.schaefer.mymovies.core.viewmodel.UIState

data class SearchViewState(val isEmpty: Boolean = true, val isLoadingEnabled: Boolean = false) : UIState {
    fun isLoadingEnabled(isEnabled: Boolean): SearchViewState {
        return this.copy(isLoadingEnabled = isEnabled)
    }
}

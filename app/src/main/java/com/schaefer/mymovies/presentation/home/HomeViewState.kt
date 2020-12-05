package com.schaefer.mymovies.presentation.home

import com.schaefer.mymovies.core.viewmodel.UIState

data class HomeViewState(val isLoading: Boolean = true) : UIState {

    fun isLoadingEnabled(isEnabled: Boolean): HomeViewState {
        return this.copy(isLoading = isEnabled)
    }
}
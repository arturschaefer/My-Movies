package com.schaefer.mymovies.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class ViewModel<State : UIState, Action : UIAction>(
    initialState: State
) : DisposableViewModel() {

    private val viewModelState = MutableLiveData(initialState)
    private val viewModelAction = MutableLiveData<Action>()

    val state: LiveData<State> = viewModelState
    val action: LiveData<Action> = viewModelAction

    protected fun setState(state: State) {
        viewModelState.value = state
    }

    protected open fun sendAction(action: Action) {
        viewModelAction.value = action
    }
}
package com.dleite.carrefourdev.arch.viewmodel

import androidx.lifecycle.LiveData
import com.dleite.carrefourdev.arch.UIAction
import com.dleite.carrefourdev.arch.UIState

abstract class ViewModel<State : UIState, Action : UIAction>(
    initialState: State
) : DisposableViewModel() {

    private val viewModelState = State(initialState)
    private val viewModelAction = Action<Action>()

    val state: LiveData<State> = viewModelState.state

    val action: LiveData<Action> = viewModelAction.action

    protected fun setState(state: (State) -> State) {
        viewModelState.setState(state)
    }

    protected open fun sendAction(action: () -> Action) {
        viewModelAction.sendAction(action)
    }
}

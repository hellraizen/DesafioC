package com.dleite.carrefourdev.src.presentation

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.dleite.carrefourdev.arch.UIAction
import com.dleite.carrefourdev.arch.UIState
import com.dleite.carrefourdev.arch.viewmodel.ViewModel

inline fun <reified State : UIState, reified Action : UIAction> Fragment.onAction(
    viewModel: ViewModel<State, Action>,
    crossinline handleEvents: (Action) -> Unit
) {
    viewModel.action.observe(this, Observer { event -> handleEvents(event as Action) })
}

inline fun <reified State : UIState, reified Action : UIAction> Fragment.onStateChange(
    viewModel: ViewModel<State, Action>,
    crossinline handleStates: (State) -> Unit
) {
    viewModel.state.observe(this, Observer { event -> handleStates(event as State) })
}


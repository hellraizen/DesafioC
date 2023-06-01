package com.dleite.carrefourdev.arch.viewmodel

import androidx.lifecycle.LiveData
import com.dleite.carrefourdev.arch.UIState
import com.dleite.carrefourdev.arch.viewmodel.plugins.ViewModelPlugins

class State<State : UIState>(initialState: State) {

    private val _state = ViewModelPlugins.factory.createMutableLiveData(initialState)
    val state: LiveData<State> = _state

    fun setState(state: (State) -> State) {
        _state.value = state(_state.value!!)
    }
}

package com.dleite.carrefourdev.arch.viewmodel

import androidx.lifecycle.LiveData
import com.dleite.carrefourdev.arch.UIAction
import com.dleite.carrefourdev.arch.viewmodel.plugins.OneShotLiveData
import com.dleite.carrefourdev.arch.viewmodel.plugins.ViewModelPlugins

class Action<Action : UIAction> {

    private val _action: OneShotLiveData<Action> = ViewModelPlugins.factory.createOneShotLiveData()
    val action: LiveData<Action> = _action

    fun sendAction(action: () -> Action) {
        _action.value = action()
    }
}

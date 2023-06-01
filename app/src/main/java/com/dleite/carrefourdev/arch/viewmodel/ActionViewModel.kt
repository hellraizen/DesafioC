package com.dleite.carrefourdev.arch.viewmodel

import com.dleite.carrefourdev.arch.UIAction

abstract class ActionViewModel<Action : UIAction> : DisposableViewModel() {

    private val actionAttribute = Action<Action>()

    fun getAction() = actionAttribute.action

    fun setAction(action: () -> Action) {
        actionAttribute.sendAction(action)
    }
}

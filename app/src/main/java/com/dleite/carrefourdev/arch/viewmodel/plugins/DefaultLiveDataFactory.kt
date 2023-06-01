package com.dleite.carrefourdev.arch.viewmodel.plugins

import androidx.lifecycle.MutableLiveData
import com.dleite.carrefourdev.arch.UIAction
import com.dleite.carrefourdev.arch.UIState

class DefaultLiveDataFactory : LiveDataFactory {

    override fun <T : UIState> createMutableLiveData(initialState: T): MutableLiveData<T> {
        return MutableLiveData(initialState)
    }

    override fun <T : UIAction> createOneShotLiveData() = OneShotLiveData<T>()
}
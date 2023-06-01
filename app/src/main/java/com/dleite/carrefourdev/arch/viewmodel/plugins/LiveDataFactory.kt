package com.dleite.carrefourdev.arch.viewmodel.plugins

import androidx.lifecycle.MutableLiveData
import com.dleite.carrefourdev.arch.UIAction
import com.dleite.carrefourdev.arch.UIState

interface LiveDataFactory {

    fun <T: UIState> createMutableLiveData(initialState: T): MutableLiveData<T>

    fun <T: UIAction> createOneShotLiveData(): OneShotLiveData<T>
}

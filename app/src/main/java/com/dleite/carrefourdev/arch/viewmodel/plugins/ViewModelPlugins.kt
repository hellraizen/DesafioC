package com.dleite.carrefourdev.arch.viewmodel.plugins

import androidx.annotation.VisibleForTesting

object ViewModelPlugins {

    var factory: LiveDataFactory = DefaultLiveDataFactory()
        private set

    @VisibleForTesting
    fun setFactory(factory: LiveDataFactory) {
        ViewModelPlugins.factory = factory
    }
}

package com.github.raininforest.bottom.navigation.extension.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard screen"
    }
    val text: LiveData<String> = _text
}
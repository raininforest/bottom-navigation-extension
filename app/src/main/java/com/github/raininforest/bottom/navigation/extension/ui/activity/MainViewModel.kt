package com.github.raininforest.bottom.navigation.extension.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.raininforest.bottom.navigation.extension.api.BottomNavigationSection
import com.github.raininforest.bottom.navigation.extension.repository.BottomNavigationRepositoryImpl
import com.github.raininforest.bottom.navigation.extension.ui.extensions.toBottomNavigationSections

class MainViewModel : ViewModel() {
    private val bottomNavigationRepository = BottomNavigationRepositoryImpl()
    private val _bottomNavigationSections = MutableLiveData<List<BottomNavigationSection>>()
    val bottomNavigationSections: LiveData<List<BottomNavigationSection>>
        get() = _bottomNavigationSections

    init {
        _bottomNavigationSections.postValue(
            bottomNavigationRepository.bottomNavigationData.toBottomNavigationSections()
        )
    }
}

package com.github.raininforest.bottom.navigation.extension.repository

import com.github.raininforest.bottom.navigation.extension.repository.data.BottomNavigationSectionData
import kotlinx.coroutines.delay

/**
 * Mocked [BottomNavigationRepository] implementation. It is just for sample.
 */
class BottomNavigationRepositoryImpl : BottomNavigationRepository {

    private val _bottomNavigationData: MutableList<BottomNavigationSectionData> = DEFAULT_BOTTOM_NAV_CONFIG

    override val bottomNavigationData: List<BottomNavigationSectionData>
        get() = _bottomNavigationData

    /**
     * Should be called from splash screen
     */
    override suspend fun load() {
        // fake delay
        delay(1000)
        _bottomNavigationData.clear()
        _bottomNavigationData.addAll(
            listOf(
                BottomNavigationSectionData("Home", "home"),
                BottomNavigationSectionData("Dashboard", "dashboard"),
                BottomNavigationSectionData("Notifications", "notifications"),
                BottomNavigationSectionData("Profile", "profile"),
                BottomNavigationSectionData("About", "about"),
            )
        )
    }

    companion object {
        private val DEFAULT_BOTTOM_NAV_CONFIG = mutableListOf(
            BottomNavigationSectionData("Home", "home"),
            BottomNavigationSectionData("Dashboard", "dashboard"),
            BottomNavigationSectionData("Notifications", "notifications", "https://www.seekpng.com/png/full/138-1387657_app-icon-set-login-icon-comments-avatar-icon.png"),
        )
    }
}

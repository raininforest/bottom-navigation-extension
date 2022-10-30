package com.github.raininforest.bottom.navigation.extension.repository

import com.github.raininforest.bottom.navigation.extension.repository.data.BottomNavigationSectionData

interface BottomNavigationRepository {
    val bottomNavigationData: List<BottomNavigationSectionData>
    suspend fun load()
}

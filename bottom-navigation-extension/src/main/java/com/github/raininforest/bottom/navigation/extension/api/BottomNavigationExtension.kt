package com.github.raininforest.bottom.navigation.extension.api

import com.github.raininforest.bottom.navigation.extension.builders.BottomNavigationConfigBuilder
import com.github.raininforest.bottom.navigation.extension.utils.setBottomNavigationSections
import com.github.raininforest.bottom.navigation.extension.utils.setBottomNavigationTint
import com.google.android.material.bottomnavigation.BottomNavigationView

fun BottomNavigationView.setup(builder: BottomNavigationConfigBuilder.() -> Unit = {}) {
    val bottomNavigationConfig = BottomNavigationConfigBuilder().apply(builder).build()
    setBottomNavigationSections(bottomNavigationConfig)
    setBottomNavigationTint(bottomNavigationConfig)
}

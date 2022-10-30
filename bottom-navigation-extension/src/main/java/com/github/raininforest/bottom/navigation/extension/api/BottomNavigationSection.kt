package com.github.raininforest.bottom.navigation.extension.api

data class BottomNavigationSection(
    val link: String,
    val title: String,
    val iconSource: IconSource = IconSource.NotDefined
)

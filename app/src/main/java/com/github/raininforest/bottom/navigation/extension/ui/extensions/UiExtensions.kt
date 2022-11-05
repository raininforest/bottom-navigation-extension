package com.github.raininforest.bottom.navigation.extension.ui.extensions

import com.github.raininforest.bottom.navigation.extension.R
import com.github.raininforest.bottom.navigation.extension.api.BottomNavigationSection
import com.github.raininforest.bottom.navigation.extension.api.IconSource
import com.github.raininforest.bottom.navigation.extension.repository.data.BottomNavigationSectionData

internal fun List<BottomNavigationSectionData>.toBottomNavigationSections(): List<BottomNavigationSection> =
    filter {
        it.iconUrl.isNotEmpty() || it.link.isNotEmpty()
    }.map {
        BottomNavigationSection(
            title = it.title,
            iconSource = if (it.iconUrl.isEmpty()) {
                IconSource.resource(it.link.mapLinkToDrawableRes())
            } else {
                IconSource.url(it.iconUrl)
            },
            link = it.link,
        )
    }

private fun String.mapLinkToDrawableRes(): Int {
    return when (this) {
        "dashboard" -> R.drawable.ic_dashboard_black_24dp
        "home" -> R.drawable.ic_home_black_24dp
        "notifications" -> R.drawable.ic_notifications_black_24dp
        else -> throw IllegalStateException()
    }
}

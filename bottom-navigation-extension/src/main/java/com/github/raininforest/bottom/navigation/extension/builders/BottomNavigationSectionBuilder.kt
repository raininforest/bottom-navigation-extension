package com.github.raininforest.bottom.navigation.extension.builders

import com.github.raininforest.bottom.navigation.extension.api.BottomNavigationSection
import com.github.raininforest.bottom.navigation.extension.api.IconSource

class BottomNavigationSectionBuilder {
    private var _id: String = ""
    private var _title: String = ""
    private var _iconSource: IconSource = IconSource.NotDefined

    fun link(id: String) {
        _id = id
    }

    fun title(title: String) {
        _title = title
    }

    fun iconSource(iconSource: IconSource) {
        _iconSource = iconSource
    }

    fun build(): BottomNavigationSection = BottomNavigationSection(
        link = _id,
        title = _title,
        iconSource = _iconSource
    )
}
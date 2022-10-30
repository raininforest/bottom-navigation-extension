package com.github.raininforest.bottom.navigation.extension.builders

import com.github.raininforest.bottom.navigation.extension.api.BottomNavigationSection
import com.github.raininforest.bottom.navigation.extension.api.SectionsBlock

class BottomNavigationSectionsBlockBuilder {
    private val sections: MutableList<BottomNavigationSection> = mutableListOf()

    fun section(builder: BottomNavigationSectionBuilder.() -> Unit = {}) {
        BottomNavigationSectionBuilder().apply(builder).build()
            .apply(sections::add)
    }

    fun build(): SectionsBlock = SectionsBlock(sections)
}
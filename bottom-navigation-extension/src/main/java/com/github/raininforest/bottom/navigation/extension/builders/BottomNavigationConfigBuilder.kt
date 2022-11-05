package com.github.raininforest.bottom.navigation.extension.builders

import android.view.MenuItem
import androidx.annotation.ColorRes
import com.github.raininforest.bottom.navigation.extension.api.BottomNavigationConfig
import com.github.raininforest.bottom.navigation.extension.api.BottomNavigationSection
import com.github.raininforest.bottom.navigation.extension.api.MenuIconLoader

class BottomNavigationConfigBuilder {
    private var onItemClicked: (BottomNavigationSection) -> Unit = {}
    private var loader: MenuIconLoader = object : MenuIconLoader {
        override fun loadIcon(menuItem: MenuItem, url: String) {
            // fallback implementation, ignore
        }
    }
    private val sections: MutableList<BottomNavigationSection> = mutableListOf()

    @ColorRes
    private var tintRes: Int? = null

    fun sections(sectionList: List<BottomNavigationSection>) {
        sections.clear()
        sections.addAll(sectionList)
    }

    fun sections(builder: BottomNavigationSectionsBlockBuilder.() -> Unit) {
        val sectionList = BottomNavigationSectionsBlockBuilder().apply(builder).build()
        sections.clear()
        sections.addAll(sectionList.sections)
    }

    fun onItemClicked(listener: (BottomNavigationSection) -> Unit) {
        onItemClicked = listener
    }

    fun remoteLoader(loader: MenuIconLoader) {
        this.loader = loader
    }

    fun tint(@ColorRes colorSelectorIdRes: Int) {
        tintRes = colorSelectorIdRes
    }

    fun build(): BottomNavigationConfig = BottomNavigationConfig(sections, tintRes, onItemClicked, loader)
}
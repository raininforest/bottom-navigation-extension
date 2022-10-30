package com.github.raininforest.bottom.navigation.extension.utils

import androidx.core.content.ContextCompat
import com.github.raininforest.bottom.navigation.extension.api.BottomNavigationConfig
import com.github.raininforest.bottom.navigation.extension.api.IconSource
import com.google.android.material.bottomnavigation.BottomNavigationView

internal fun BottomNavigationView.setBottomNavigationSections(bottomNavigationConfig: BottomNavigationConfig) {
    menu.clear()
    bottomNavigationConfig.sectionList.forEachIndexed { index, bottomNavigationSection ->
        menu.add(0, index, index, bottomNavigationSection.title).apply {
            when (val src = bottomNavigationSection.iconSource) {
                is IconSource.ResourceId -> setIcon(src.drawableResourceId)
                is IconSource.Url -> bottomNavigationConfig.loader.loadIcon(this, src.url)
                IconSource.NotDefined -> {}
            }

            setOnMenuItemClickListener {
                bottomNavigationConfig.onItemClicked(bottomNavigationSection)
                false
            }
        }
    }
}

internal fun BottomNavigationView.setBottomNavigationTint(config: BottomNavigationConfig) {
    config.tint?.let {
        itemIconTintList = ContextCompat.getColorStateList(context, it)
        itemTextColor = ContextCompat.getColorStateList(context, it)
    }
}

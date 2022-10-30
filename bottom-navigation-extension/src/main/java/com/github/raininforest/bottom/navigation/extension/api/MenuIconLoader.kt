package com.github.raininforest.bottom.navigation.extension.api

import android.view.MenuItem

interface MenuIconLoader {
    fun loadIcon(menuItem: MenuItem, url: String)
}
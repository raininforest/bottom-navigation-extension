package com.github.raininforest.bottom.navigation.extension.glide.loader

import android.content.Context
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.github.raininforest.bottom.navigation.extension.api.MenuIconLoader

class GlideMenuIconLoader(private val context: Context) : MenuIconLoader {
    override fun loadIcon(menuItem: MenuItem, url: String) {
        Glide.with(context)
            .asBitmap()
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .into(MenuItemTarget(context, menuItem))
    }
}

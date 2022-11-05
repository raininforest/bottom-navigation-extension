package com.github.raininforest.bottom.navigation.extension.glide.loader

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.MenuItem
import androidx.core.graphics.drawable.toDrawable
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

internal class MenuItemTarget(
    private val context: Context,
    private val menuItem: MenuItem
) : CustomTarget<Bitmap>() {
    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
        menuItem.icon = resource.toDrawable(context.resources)
    }

    override fun onLoadCleared(placeholder: Drawable?) {
        // ignore
    }
}

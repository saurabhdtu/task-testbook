package com.tb.task.ui

import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageLoaderUtils {
    fun setImage(imageView: ImageView, imageUrl: String?, width: Int, height: Int) {
        if (imageUrl != null) {
            Picasso.get().load("https:${imageUrl}")
                .resize(
                    width,
                    height
                )
                .centerCrop()
                .into(imageView)
        }
    }

}
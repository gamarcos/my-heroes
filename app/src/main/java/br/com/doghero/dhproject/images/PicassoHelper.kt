package br.com.doghero.dhproject.images

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by Gabriel Marcos on 22/10/2018
 */
class PicassoHelper(private val context: Context?) {

    fun loadImage(url: String?, view: ImageView) {
        Picasso.with(context)
                .load(url)
                .fit()
                .centerCrop()
                .into(view)
    }
}
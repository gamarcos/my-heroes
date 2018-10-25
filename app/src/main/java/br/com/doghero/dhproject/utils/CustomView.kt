package br.com.doghero.dhproject.utils

import android.app.Activity
import android.view.WindowManager

/**
 * Created by Gabriel Marcos on 22/10/2018
 */
class CustomView {
    fun setActionBarTransparent(activity: Activity) {
        val w = activity.window
        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
    }
}
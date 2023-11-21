package com.dkm.app.utils

import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import com.google.android.material.textfield.TextInputLayout


/**
 * Created by akash on 11/21/2023.
 * Know more about author on <a href="https://akash.cloudemy.in">...</a>
 */
@androidx.databinding.BindingAdapter("setErrorText")
fun TextInputLayout.setErrorText(error: String?) {
    if (!error.isNullOrBlank()) {
        isErrorEnabled = true
        setError(error)
    } else {
        isErrorEnabled = false
        setError("")
    }

}


fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    if (visibility == View.GONE || visibility == View.INVISIBLE)
        visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}



fun View.fadeIn() {
    val fadeIn: Animation = AlphaAnimation(0f, 1f)
    fadeIn.interpolator = DecelerateInterpolator() //add this
    fadeIn.duration = 300
    val animation = AnimationSet(false) //change to false
    animation.addAnimation(fadeIn)
    this.animation = animation
    this.animate()
}

fun View.fadeOut() {

    val fadeOut: Animation = AlphaAnimation(1f, 0f)
    fadeOut.interpolator = AccelerateInterpolator() //and this
    fadeOut.startOffset = 300
    fadeOut.duration = 100
    val animation = AnimationSet(false) //change to false
    animation.addAnimation(fadeOut)
    this.animation = animation
    animation.start()
}
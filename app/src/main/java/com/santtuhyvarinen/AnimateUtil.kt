package com.santtuhyvarinen

import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation
import android.widget.TextView

class AnimateUtil {
    companion object {
        const val TEXT_ANIMATION_SPEED = 100L

        fun animateTextChange(textView : TextView, newText : String) {
            val scaleAnimationExit = ScaleAnimation(
                1f, 1f,
                1f, 0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)

            val scaleAnimationEntrance = ScaleAnimation(
                1f, 1f,
                0f, 1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)

            scaleAnimationExit.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    textView.text = newText
                    textView.startAnimation(scaleAnimationEntrance)
                }

                override fun onAnimationRepeat(p0: Animation?) {
                }
            })

            scaleAnimationExit.interpolator = DecelerateInterpolator()
            scaleAnimationEntrance.interpolator = AccelerateDecelerateInterpolator()

            scaleAnimationExit.duration = TEXT_ANIMATION_SPEED
            scaleAnimationEntrance.duration = TEXT_ANIMATION_SPEED

            //First play scaleAnimationExit and then play scaleAnimationEntrance
            textView.startAnimation(scaleAnimationExit)
        }
    }
}
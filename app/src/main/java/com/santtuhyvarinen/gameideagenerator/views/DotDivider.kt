package com.santtuhyvarinen.gameideagenerator.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat

class DotDivider(context : Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    var dotRadius = 5f
    var dotColor = Color.WHITE
    var dots = 5

    val paint : Paint = Paint()
    init {
        paint.isAntiAlias = true
        paint.color = dotColor
        paint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if(dots <= 0) return

        val step = width / dots
        val offset = step / 2f

        val Y = height / 2f

        for(X in 0 until dots) {
            canvas.drawCircle(offset + (X * step), Y, dotRadius, paint)
        }
    }
}
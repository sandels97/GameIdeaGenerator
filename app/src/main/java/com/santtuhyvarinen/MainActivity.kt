package com.santtuhyvarinen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var ideaGenerator : IdeaGenerator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ideaGenerator = IdeaGenerator(this)

        generateButton.setOnClickListener {
            generateIdea()
        }

        //Button drawable
        val drawable = ContextCompat.getDrawable(this, R.drawable.ic_dice)
        val size = resources.getDimensionPixelSize(R.dimen.buttonDrawableSize)
        drawable?.setBounds(0, 0, size, size)
        generateButton.setCompoundDrawables(null, null, drawable, null)

        generateIdea()
    }

    private fun generateIdea() {
        AnimateUtil.animateTextChange(gameIdeaText, ideaGenerator.generateNewIdea())
    }
}
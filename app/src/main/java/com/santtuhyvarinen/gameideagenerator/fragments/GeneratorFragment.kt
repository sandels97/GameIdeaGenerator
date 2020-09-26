package com.santtuhyvarinen.gameideagenerator.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.santtuhyvarinen.gameideagenerator.IdeaGenerator
import com.santtuhyvarinen.R
import com.santtuhyvarinen.gameideagenerator.utils.AnimateUtil
import kotlinx.android.synthetic.main.fragment_generator.*
import kotlinx.android.synthetic.main.layout_game_idea.*

class GeneratorFragment : Fragment() {

    lateinit var ideaGenerator : IdeaGenerator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_generator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ideaGenerator = IdeaGenerator(requireContext())

        generateButton.setOnClickListener {
            generateIdea()
        }

        //Button drawable
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_dice)
        val size = resources.getDimensionPixelSize(R.dimen.buttonDrawableSize)
        drawable?.setBounds(0, 0, size, size)
        generateButton.setCompoundDrawables(null, null, drawable, null)

        generateIdea()
    }

    private fun generateIdea() {
        AnimateUtil.animateTextChange(gameIdeaText, ideaGenerator.generateNewIdea())
    }
}
package com.santtuhyvarinen.gameideagenerator.fragments

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.santtuhyvarinen.gameideagenerator.IdeaGenerator
import com.santtuhyvarinen.R
import com.santtuhyvarinen.gameideagenerator.utils.AnimateUtil
import com.santtuhyvarinen.gameideagenerator.utils.FavoritesUtil
import kotlinx.android.synthetic.main.fragment_generator.*
import kotlinx.android.synthetic.main.layout_game_idea.*

class GeneratorFragment : Fragment() {

    lateinit var ideaGenerator : IdeaGenerator

    var favorites : ArrayList<String> = ArrayList()
    var currentIdea = ""

    var favoriteAlready = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_generator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ideaGenerator = IdeaGenerator(requireContext())

        generateButton.setOnClickListener {
            generateIdea()
        }

        favoriteButton.setOnClickListener {
            if(favoriteAlready) {
                Toast.makeText(requireContext(), getString(R.string.favorite_already), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            favorites.add(currentIdea)
            val success = FavoritesUtil.saveFavorites(requireContext(), favorites)

            if(success) {
                Toast.makeText(requireContext(), getString(R.string.favorite_added), Toast.LENGTH_SHORT).show()
                favoriteButton.isSelected = true
                favoriteAlready = true
            }
        }

        favorites = FavoritesUtil.loadFavorites(requireContext())

        //Button drawable for generate and favorite buttons
        setButtonDrawable(generateButton, R.drawable.ic_dice, R.dimen.buttonDrawableSize)
        setButtonDrawable(favoriteButton, R.drawable.ic_favorite, R.dimen.buttonDrawableSize)

        val dividerDots = 10
        divider1.dots = dividerDots
        divider2.dots = dividerDots

        generateIdea()
    }
    private fun setButtonDrawable(button : Button, drawableId : Int, dimenId : Int) {
        val drawable = ContextCompat.getDrawable(requireContext(), drawableId)
        val size = resources.getDimensionPixelSize(dimenId)
        drawable?.setBounds(0, 0, size, size)
        drawable?.setTint(Color.BLACK)
        button.setCompoundDrawables(null, null, drawable, null)

    }
    private fun generateIdea() {
        favoriteButton.isSelected = false
        favoriteAlready = false

        currentIdea = ideaGenerator.generateNewIdea()
        AnimateUtil.animateTextChange(gameIdeaLayout, gameIdeaText, currentIdea)
    }
}
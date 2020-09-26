package com.santtuhyvarinen.gameideagenerator.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.santtuhyvarinen.gameideagenerator.IdeaGenerator
import com.santtuhyvarinen.R
import com.santtuhyvarinen.gameideagenerator.adapters.FavoritesAdapter
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment : Fragment() {

    lateinit var gameIdeaGenerator : IdeaGenerator
    lateinit var favoritesAdapter : FavoritesAdapter

    var favorites = ArrayList<String>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        gameIdeaGenerator = IdeaGenerator(requireContext())

        favorites.add(gameIdeaGenerator.generateNewIdea())
        favorites.add(gameIdeaGenerator.generateNewIdea())
        favorites.add(gameIdeaGenerator.generateNewIdea())
        favorites.add(gameIdeaGenerator.generateNewIdea())

        favoritesAdapter = FavoritesAdapter(requireContext(), favorites)
        recyclerView.adapter = favoritesAdapter

    }

}
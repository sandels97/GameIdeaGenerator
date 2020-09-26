package com.santtuhyvarinen.gameideagenerator.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.santtuhyvarinen.gameideagenerator.IdeaGenerator
import com.santtuhyvarinen.R

class FavoritesFragment : Fragment() {

    lateinit var ideaGenerator : IdeaGenerator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
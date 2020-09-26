package com.santtuhyvarinen

import android.content.Context
import java.util.*
import kotlin.random.Random

class IdeaGenerator(context: Context) {

    val genres : Array<String>
    val themes : Array<String>
    val adjectives : Array<String>
    init {
        genres = context.resources.getStringArray(R.array.Genres)
        themes = context.resources.getStringArray(R.array.Themes)
        adjectives = context.resources.getStringArray(R.array.Adjectives)
    }

    fun generateNewIdea() : String {
        val genre = genres[Random.nextInt(genres.size)]

        var genre2: String
        while (true) {
            genre2 = genres[Random.nextInt(genres.size)]

            //Don't pick the same genre twice
            if(genre2 != genre) break
        }

        val theme = themes[Random.nextInt(themes.size)]
        val adjective = adjectives[Random.nextInt(adjectives.size)]

        val string = "${adjective} ${theme.toLowerCase(Locale.ROOT)}\n${genre.toLowerCase(Locale.ROOT)} game\nwith ${genre2.toLowerCase(Locale.ROOT)} elements"

        return string
    }
}
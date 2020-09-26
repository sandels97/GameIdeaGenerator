package com.santtuhyvarinen.gameideagenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.santtuhyvarinen.R

class MainActivity : AppCompatActivity() {

    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.navigationView)
        navController = findNavController(this, R.id.nav_host_fragment)

        NavigationUI.setupWithNavController(navView, navController)

        val appBarConfiguration = AppBarConfiguration
            .Builder(
                R.id.navigation_generator,
                R.id.navigation_favorites)
            .build()

        setupActionBarWithNavController(this, navController, appBarConfiguration)
    }
}
package com.hendrizzzz.dba.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hendrizzzz.dba.ui.theme.DBATheme
import com.hendrizzzz.dba.view.DiscoverScreen
import com.hendrizzzz.dba.view.GamesScreen
import com.hendrizzzz.dba.view.HomeScreen
import com.hendrizzzz.dba.view.PlayersScreen
import com.hendrizzzz.dba.view.TeamsScreen

class DBALauncher : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DBATheme {
                NavGraph() // Set up the main navigation screen
            }
        }
    }
}


@Composable
fun NavGraph() {
    val navController = rememberNavController() // Remember the nav controller

    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { HomeScreen(navController) }
        composable("Discover") { DiscoverScreen(navController) }
        composable("Games") { GamesScreen(navController) }
        composable("Teams") { TeamsScreen(navController) }
        composable("Players") { PlayersScreen(navController) }
    }
}

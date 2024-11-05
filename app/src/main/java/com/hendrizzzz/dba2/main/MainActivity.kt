package com.hendrizzzz.dba2.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hendrizzzz.dba2.R
import com.hendrizzzz.dba2.view.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var selectedButton by remember { mutableStateOf("Home") } // Set initial selected button

    // Sample articles - declare the articles here
    val articles = listOf(
        Article(1, android.R.drawable.ic_menu_gallery, "Article Title 1", "Content of Article 1"),
        Article(2, android.R.drawable.ic_menu_gallery, "Article Title 2", "Content of Article 2"),
        Article(3, android.R.drawable.ic_menu_gallery, "Article Title 3", "Content of Article 3"),
        Article(4, android.R.drawable.ic_menu_gallery, "Article Title 4", "Content of Article 4"),
        Article(5, android.R.drawable.ic_menu_gallery, "Article Title 5", "Content of Article 5")
    )

    // Scaffold to provide bottom navigation
    Scaffold(
        bottomBar = {
            BottomNavigationPanel(selectedButton) { buttonLabel ->
                selectedButton = buttonLabel
                if (buttonLabel == "Home") {
                    navController.navigate("home") {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                    }
                } else {
                    navController.navigate(buttonLabel.lowercase())
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = "home", Modifier.padding(innerPadding)) {
            composable("home") { HomeScreen(navController, selectedButton, articles) }
            composable("games") { GamesScreen() }
            composable("teams") { TeamsScreen() }
            composable("players") { PlayersScreen() }
            composable("discover") { DiscoverScreen() }
            composable("article/{articleId}") { backStackEntry ->
                val articleId = backStackEntry.arguments?.getString("articleId")?.toInt() ?: 0
                val article = articles.find { it.id == articleId } // Find the article by ID
                if (article != null) {
                    ArticleDetailScreen(article) // Pass the article to the detail screen
                }
            }
        }
    }
}

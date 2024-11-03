package com.hendrizzzz.dba.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hendrizzzz.dba.ui.theme.DBATheme

class GamesView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DBATheme {
                // Initialize NavHostController
                val navController = rememberNavController()
                GamesScreen(navController = navController)
            }
        }
    }
}

@Composable
fun GamesScreen(navController: NavHostController) {
    var selectedButton by remember { mutableStateOf("Games") }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Welcome to Games",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the bottom panel down

        BottomNavigationPanel(selectedButton = selectedButton, onButtonClick = { button ->
            selectedButton = button
            when (button) {
                "Home" -> navController.navigate("Home")
                "Teams" -> navController.navigate("Teams")
                "Players" -> navController.navigate("Players")
                "Discover" -> navController.navigate("Discover")
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun GamesScreenPreview() {
    // Create a mock NavHostController or use a dummy implementation
    val navController = rememberNavController()
    DBATheme {
        GamesScreen(navController = navController)
    }
}

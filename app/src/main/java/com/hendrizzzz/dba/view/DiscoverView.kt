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

class DiscoverView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DBATheme {
                // Initialize NavHostController
                val navController = rememberNavController()
                DiscoverScreen(navController = navController)
            }
        }
    }
}

@Composable
fun DiscoverScreen(navController: NavHostController) {
    var selectedButton by remember { mutableStateOf("Discover") }

    Column(modifier = Modifier.fillMaxSize()) {
        // Content of Discover screen goes here
        Text(
            text = "Welcome to Discover",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the bottom panel down

        BottomNavigationPanel(selectedButton = selectedButton, onButtonClick = { button ->
            selectedButton = button
            when (button) {
                "Games" -> navController.navigate("Games")
                "Teams" -> navController.navigate("Teams")
                "Players" -> navController.navigate("Players")
                "Home" -> navController.navigate("Home")
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DiscoverScreenPreview() {
    // Create a mock NavHostController or use a dummy implementation
    val navController = rememberNavController()
    DBATheme {
        DiscoverScreen(navController = navController)
    }
}

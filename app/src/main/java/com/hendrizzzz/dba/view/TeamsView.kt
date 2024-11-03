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

class TeamsView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DBATheme {
                // Initialize NavHostController
                val navController = rememberNavController()
                TeamsScreen(navController = navController)
            }
        }
    }
}

@Composable
fun TeamsScreen(navController: NavHostController) {
    var selectedButton by remember { mutableStateOf("Teams") }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Welcome to Teams",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the bottom panel down

        BottomNavigationPanel(selectedButton = selectedButton, onButtonClick = { button ->
            selectedButton = button
            when (button) {
                "Games" -> navController.navigate("Games")
                "Home" -> navController.navigate("Home")
                "Players" -> navController.navigate("Players")
                "Discover" -> navController.navigate("Discover")
            }
        })
    }
}

@Preview(showBackground = true)
@Composable
fun TeamsScreenPreview() {
    // Create a mock NavHostController or use a dummy implementation
    val navController = rememberNavController()
    DBATheme {
        TeamsScreen(navController = navController)
    }
}

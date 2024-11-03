package com.hendrizzzz.dba.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hendrizzzz.dba.R
import com.hendrizzzz.dba.ui.theme.DBATheme
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


class HomeView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DBATheme {
                // Initialize NavHostController
                val navController = rememberNavController()
                NavigationGraph(navController) // Call the NavigationGraph
            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "Home") {
        composable("Home") { HomeScreen(navController) }
        composable("Games") { GamesScreen(navController) }
        composable("Teams") { TeamsScreen(navController) }
        composable("Players") { PlayersScreen(navController) }
        composable("Discover") { DiscoverScreen(navController) }
    }
}


@Composable
fun HomeScreen(navController: NavHostController) {
    var selectedButton by remember { mutableStateOf("Home") }
    var message by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        Header(onIconClick = { message = it })

        Text(
            text = message,
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )

        Text(
            text = "Welcome to Home",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        BottomNavigationPanel(selectedButton = selectedButton, onButtonClick = { button ->
            selectedButton = button
            when (button) {
                "Games" -> navController.navigate("Games")
                "Teams" -> navController.navigate("Teams")
                "Players" -> navController.navigate("Players")
                "Discover" -> navController.navigate("Discover")
            }
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(onIconClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 12.dp, shape = RectangleShape, clip = false)
            .background(Color.Black)
    ) {
        TopAppBar(
            title = {
                Spacer(modifier = Modifier.width(0.dp))
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                titleContentColor = Color.White
            ),
            navigationIcon = {
                IconButton(
                    onClick = { onIconClick("Logo clicked!") },
                    modifier = Modifier
                        .padding(10.dp)
                        .size(80.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.dba_logo),
                        contentDescription = "Logo",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = { onIconClick("Search clicked!") },
                    modifier = Modifier
                        .padding(10.dp)
                        .shadow(elevation = 4.dp, shape = RectangleShape, clip = false)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }

                IconButton(
                    onClick = { onIconClick("User clicked!") },
                    modifier = Modifier
                        .padding(10.dp)
                        .shadow(elevation = 4.dp, shape = RectangleShape, clip = false)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "User",
                        tint = Color.White
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    DBATheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}

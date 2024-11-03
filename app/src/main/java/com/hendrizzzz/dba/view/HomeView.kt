package com.hendrizzzz.dba.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

class HomeView : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DBATheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var message by remember { mutableStateOf("") } // State to hold the message

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header(onIconClick = { message = it }) // Pass the message update function to the Header
        Spacer(modifier = Modifier.weight(1f)) // Spacer to push the button panel to the bottom

        // Display the message in the center of the screen
        Text(
            text = message,
            color = Color.Black, // Ensure this is visible
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally) // Center the text
                .padding(16.dp) // Add some padding for aesthetics
        )

        // Bottom navigation panel, do not show the message here
        BottomNavigationPanel(onButtonClick = { message = it }) // Pass the message to update on button click
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(onIconClick: (String) -> Unit) {
    TopAppBar(
        title = {
            // Leaving this empty or set to null keeps it without a title
            Spacer(modifier = Modifier.width(0.dp))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.Black
        ),
        navigationIcon = {
            // Left side: Logo as Icon
            IconButton(onClick = { onIconClick("Logo clicked!") }) {
                Icon(
                    painter = painterResource(id = R.drawable.dba_logo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(300.dp)
                )
            }
        },
        actions = {
            // Right side: Search Icon
            IconButton(onClick = { onIconClick("Search clicked!") }) {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search"
                )
            }

            // User Icon
            IconButton(onClick = { onIconClick("User clicked!") }) {
                Icon(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "User"
                )
            }
        }
    )
}

@Composable
fun BottomNavigationPanel(onButtonClick: (String) -> Unit) {
    // Create a bottom navigation panel
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Center the content
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Button for Games
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onButtonClick("Games clicked!") } // Apply click listener to entire column
                    .padding(top = 5.dp, bottom = 0.dp)
                    .width(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.basketball),
                    contentDescription = "Games",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Games",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(0.dp)
                )
            }

            // Button for Teams
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onButtonClick("Teams clicked!") }
                    .padding(top = 5.dp, bottom = 0.dp)
                    .width(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.teams),
                    contentDescription = "Teams",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Teams",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(0.dp)
                )
            }

            // Button for Home
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onButtonClick("Home clicked!") }
                    .padding(top = 5.dp, bottom = 0.dp)
                    .width(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Home",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(0.dp)
                )
            }

            // Button for Players
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onButtonClick("Players clicked!") }
                    .padding(top = 5.dp, bottom = 0.dp)
                    .width(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.players),
                    contentDescription = "Players",
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = "Players",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(0.dp)
                )
            }

            // Button for Discover
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onButtonClick("Discover clicked!") }
                    .padding(top = 5.dp, bottom = 0.dp)
                    .width(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.discover),
                    contentDescription = "Discover",
                    modifier = Modifier.size(24.dp).padding(0.dp)
                )
                Text(
                    text = "Discover",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(0.dp)
                )
            }
        }
    }
}






@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    DBATheme {
        MainScreen()
    }
}

package com.hendrizzzz.dba2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hendrizzzz.dba2.R
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderPanel(onIconClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 12.dp, shape = RectangleShape, clip = false)
            .background(Color.Black)
            .padding(0.dp)
    ) {
        TopAppBar(
            title = { /* Empty title if not needed */ },
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
                        tint = Color.White
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = { onIconClick("Search clicked!") },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search",
                        tint = Color.White
                    )
                }
                IconButton(
                    onClick = { onIconClick("User clicked!") },
                    modifier = Modifier.padding(10.dp)
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

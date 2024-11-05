package com.hendrizzzz.dba2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import androidx.compose.foundation.lazy.items



class HomeTeamView : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    val navController = rememberNavController()
                    // Pass both navController, selectedButton, and a list of articles
                    HomeScreen(
                        navController = navController,
                        selectedButton = "Home",
                        articles = listOf(
                            Article(1, android.R.drawable.ic_menu_gallery, "Sample Article", "Sample content"),
                            Article(2, android.R.drawable.ic_menu_gallery, "Another Article", "More content here")
                        )
                    )
                }
            }
        }
    }
}



@Composable
fun HomeScreen(navController: NavHostController, selectedButton: String, articles: List<Article>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 60.dp, 0.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Center all items horizontally
    ) {
        items(articles) { article ->
            ImageWithDescription(article, navController)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    HeaderPanel {  }
}




@Composable
fun ImageWithDescription(article: Article, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // Navigate to the article details
                navController.navigate("article/${article.id}")
            }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Center items inside Column
    ) {
        Image(
            painter = painterResource(id = article.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Gray)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = article.title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(8.dp)
        )
    }
}


@Composable
fun ArticleDetailScreen(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = article.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = article.title,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = article.content,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeTeamScreen() {
    MaterialTheme {
        // You can simplify preview by removing the navigation logic if it's not needed
        HomeScreen(navController = rememberNavController(), selectedButton = "Home", articles = listOf(
            Article(1, android.R.drawable.ic_menu_gallery, "Sample Article", "Sample content")
        ))
    }
}



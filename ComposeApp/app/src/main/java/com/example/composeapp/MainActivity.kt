package com.example.composeapp

import ProfileContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.model.List_HERO
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // Create a NavController
                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Set up NavHost with the NavController
                    NavHost(navController = navController, startDestination = "listHeroApp") {
                        composable("listHeroApp") { ListHeroAPP(navController = navController) }
                        composable("profileContent") { ProfileContent() }
                        composable("description/{id}") { backStackEntry ->
                            val infgameId = backStackEntry.arguments?.getString("id")
                            val infgame = List_HERO.ListHERO.find { it.id == infgameId }
                            if (infgame != null) {
                                InfgameDetailPage(hero = infgame)
                            }
                            // Add other destinations as needed
                        }

                    }
                }
            }
        }
    }
}

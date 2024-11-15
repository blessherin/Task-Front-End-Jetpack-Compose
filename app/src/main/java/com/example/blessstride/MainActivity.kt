package com.example.blessstride

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.blessstride.presentation.screen.Screen
import com.example.blessstride.presentation.view.AboutScreen
import com.example.blessstride.presentation.view.DetailKategori
import com.example.blessstride.presentation.view.ExploreScreen
import com.example.blessstride.presentation.view.HomeScreen
import com.example.blessstride.presentation.viewModel.UserVM
import com.example.blessstride.ui.theme.BlessStrideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            BlessStrideTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Navigation()
                }
            }
        }
    }

    @Composable
    fun Navigation() {
        val navController = rememberNavController()
        val destinationPage = Screen.Home.route

        NavHost(
            navController = navController,
            startDestination = destinationPage,
        ){
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }

            composable(Screen.Explore.route) {
                ExploreScreen(navController = navController) {}
            }

            composable(Screen.About.route){
                val userVM = UserVM()
                AboutScreen(navController = navController, userVM = userVM)
            }

            composable(
                route = Screen.DetailKategori.route,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                val kategoriId = backStackEntry.arguments?.getInt("id")
                kategoriId?.let {
                    DetailKategori(navController = navController, id = it)
                }
            }
        }
        
    }
}
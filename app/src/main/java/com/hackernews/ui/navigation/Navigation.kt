package com.hackernews.ui.navigation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.hackernews.ui.detail.DetailHomeScreen
import com.hackernews.ui.detail.DetailViewModel
import com.hackernews.ui.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(
                onHackerNewsClick = { navController.navigate("detail/${it.id}") },
            )
        }
        composable(
            route = "detail/{value}",
            arguments = listOf(navArgument("value") { type = NavType.IntType })
        ) { id ->
            val idX = id.arguments?.getInt("value")
            idX?.let { DetailViewModel(it) }?.let {
                DetailHomeScreen(
                    vm = it,
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}
package com.interview.interviewtrainingapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.interview.interviewtrainingapp.ui.home.HomeScreen
import com.interview.interviewtrainingapp.ui.splash.SplashScreen

@Composable
fun NavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = Navigation.Splash.destination) {
        composable(Navigation.Splash.destination) {
            SplashScreen(onNavigate = {
                navController.navigate(Navigation.Home.destination) {
                    popUpTo(Navigation.Splash.destination) {
                        inclusive = true
                    }
                }
            })
        }
        mainNavigation(navController)
    }
}


private fun NavGraphBuilder.mainNavigation(navController: NavHostController) {
    navigation(startDestination = Navigation.Home.destination, route = Route.Main.destination) {
        composable(Navigation.Home.destination) {
            HomeScreen(navController = navController)
        }
    }
}
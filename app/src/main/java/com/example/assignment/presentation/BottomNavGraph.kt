package com.example.assignment.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assignment.presentation.Explore.ExploreScreen
import com.example.assignment.presentation.Refine.RefineScreen

@Composable
fun BottomNavGrapg(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Refine.route){
        composable(route = BottomBarScreen.Refine.route){
            RefineScreen()
        }
        composable(route = BottomBarScreen.Explore.route){
            ExploreScreen()
        }
        composable(route = BottomBarScreen.Network.route){
        }
        composable(route = BottomBarScreen.Chat.route){
        }
        composable(route = BottomBarScreen.Contacts.route){
        }
    }
}
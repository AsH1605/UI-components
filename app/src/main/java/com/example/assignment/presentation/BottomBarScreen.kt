package com.example.assignment.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.ConnectWithoutContact
import androidx.compose.material.icons.filled.ContactPage
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.assignment.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Refine: BottomBarScreen(
        route = "Refine",
        title = "Refine",
        icon = Icons.Default.FilterList
    )
    object Explore: BottomBarScreen(
        route = "Explore",
        title = "Explore",
        icon = Icons.Default.RemoveRedEye
    )
    object Network: BottomBarScreen(
        route = "Network",
        title = "Netwo",
        icon = Icons.Default.ConnectWithoutContact
    )
    object Chat: BottomBarScreen(
        route = "Chat",
        title = "Chat",
        icon = Icons.Default.ChatBubbleOutline
    )
    object Contacts: BottomBarScreen(
        route = "Contacts",
        title = "Conta",
        icon = Icons.Default.ContactPage
    )
}
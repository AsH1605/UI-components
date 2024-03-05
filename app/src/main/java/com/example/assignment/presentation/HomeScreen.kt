package com.example.assignment.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.ConnectWithoutContact
import androidx.compose.material.icons.filled.ContactPage
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.assignment.R

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopAppBar(
    modifier: Modifier = Modifier
){
    var selectedText by remember { mutableStateOf("INDIVIDUAL") }
    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Column {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = Color.White,
                    ),
                    title = {
                        Column (
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ){
                            Text(
                                "Explore",
                                maxLines = 1,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = modifier.height(4.dp))
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "location"
                                )
                                Text(
                                    text = "Location",
                                    maxLines = 1,
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier
                                        .padding(start = 0.5.dp)
                                        .weight(0.9f)
                                )
                            }
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.menu),
                                contentDescription = "Menu",
                                modifier = Modifier.size(24.dp),
                                tint = Color.White
                            )
                        }
                    },
                    actions = {
                        Row {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    imageVector = Icons.Filled.Notifications,
                                    contentDescription = "Bell",
                                    tint = Color.White
                                )
                            }
                        }
                    },
                    scrollBehavior = scrollBehavior,
                )
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.tertiary,
                    ),
                    title = {
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            createClickableText(
                                text = "INDIVIDUAL",
                                isSelected = selectedText == "INDIVIDUAL",
                                onClick = {
                                    selectedText = "INDIVIDUAL"
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            )
                            createClickableText(
                                text = "PROFESSIONAL",
                                isSelected = selectedText == "PROFESSIONAL",
                                onClick = {
                                    selectedText = "PROFESSIONAL"
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            )
                            createClickableText(
                                text = "MERCHANT",
                                isSelected = selectedText == "MERCHANT",
                                onClick = {
                                    selectedText = "MERCHANT"
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            )
                        }
                    }
                )
                DrawLine(selectedText)
            }
        },
        bottomBar = {
            CustomBottomAppBar(navController = navController)
        }
    ){paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            BottomNavGrapg(navController = navController)
        }
    }
}

@Composable
fun DrawLine(selectedText: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(Color.Gray)
    ) {
        // Draw a line only below the selected text
        if (selectedText == "INDIVIDUAL") {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            ) {
                drawLine(
                    color = Color.White,  // Change color as needed
                    start = Offset(0f, size.height),
                    end = Offset(1f / 3f * size.width, size.height),
                    strokeWidth = 3f
                )
            }
        }
        if (selectedText == "MERCHANT") {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            ) {
                drawLine(
                    color = Color.White,  // Change color as needed
                    start = Offset(2f / 3f * size.width, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 3f
                )
            }
        }
        if (selectedText == "PROFESSIONAL") {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
            ) {
                drawLine(
                    color = Color.White,  // Change color as needed
                    start = Offset(0.9f / 3f * size.width, size.height),
                    end = Offset(2f / 3f * size.width, size.height),
                    strokeWidth = 3f
                )
            }
        }
    }
}


@Composable
fun createClickableText(text: String, isSelected: Boolean, onClick: () -> Unit,modifier: Modifier = Modifier ) {
    val selectedColor = if (isSelected) Color.White else Color.DarkGray

    Text(
        text = text,
        maxLines = 1,
        style = MaterialTheme.typography.titleSmall.copy(
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = selectedColor
        ),
        modifier = Modifier
            .clickable { onClick() }
            .padding(8.dp)
    )
}

@Composable
fun CustomBottomAppBar(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val list = listOf(
        BottomBarScreen.Refine,
        BottomBarScreen.Explore,
        BottomBarScreen.Network,
        BottomBarScreen.Chat,
        BottomBarScreen.Contacts
    )
    var selectedIndex by remember { mutableStateOf(list.indexOfFirst { it.route == currentRoute }) }
    NavigationBar{
        list.forEachIndexed { index, screens->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                          navController.navigate(screens.route)
                            selectedIndex = index
                          },
                icon = {
                    Icon(
                        imageVector = screens.icon,
                        contentDescription = screens.title,
                        tint = if (selectedIndex == index) MaterialTheme.colorScheme.primary else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = screens.title,
                        color = if (selectedIndex == index) MaterialTheme.colorScheme.primary else Color.Gray
                    )
                },
                alwaysShowLabel = true
            )
        }
    }
}

//@Composable
//fun Screen(selectedIndex: Int){
//    if(selectedIndex == 1){
//    }
//}

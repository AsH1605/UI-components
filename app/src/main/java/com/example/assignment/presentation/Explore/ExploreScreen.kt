package com.example.assignment.presentation.Explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.assignment.R

@Composable
fun ExploreScreen (){
    Column{
        SearchBar()
        val exploreItems = listOf(
            ExploreItem(
                "Michael Murphy",
                "San Francisco, within 1 Km",
                "Friendship",
                "Coffee",
                "Hangout",
                "Hi community! I am open to new connections.",
                R.drawable.p1
            ),
            ExploreItem(
                "John Doe",
                "San Francisco, within 1 Km",
                "Coffee",
                "Movies",
                "Hobbies",
                "Going to Berkley, would love to share a ride with someone like minded",
                R.drawable.p2
            ),
            ExploreItem(
                "Jennifer",
                "San Francisco, within 1 Km",
                "Friendship",
                "Coffee",
                "Hangout",
                "Hi community! I am open to new connections.",
                R.drawable.p3
            ),
        )

        LazyColumn{
            items(exploreItems) { exploreItem ->
                Component(exploreItem)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        OutlinedTextField(
            value = searchText,
            onValueChange = { newText ->
                searchText = newText
            },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
                .height(48.dp),
            label = { Text("Search") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Gray
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text
            ),
            singleLine = true,
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.Gray,
                cursorColor = MaterialTheme.colorScheme.primary
            )
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "Search",
                modifier = Modifier
                    .size(30.dp)
                    .offset(y = 5.dp),
                tint = Color.Gray
            )
        }
    }
}

@Preview
@Composable
fun ExploreScreenPreview(){
    ExploreScreen()
}
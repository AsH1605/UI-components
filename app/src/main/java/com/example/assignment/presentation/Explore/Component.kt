package com.example.assignment.presentation.Explore

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ExploreItem(
    val name: String,
    val place: String,
    val P1: String,
    val P2: String,
    val P3: String,
    val Descp: String,
    val path: Int
)

@Composable
fun Component(exploreItem: ExploreItem){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 55.dp,
                    top = 30.dp,
                    end = 55.dp,
                    bottom = 0.dp
                )
                .align(Alignment.TopCenter)
                .shadow(
                    elevation = 25.dp,
                    ambientColor = Color.DarkGray,
                    spotColor = Color.White,
                    shape = RoundedCornerShape(20.dp)
                ),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(start = 55.dp,
                                top = 25.dp,
                                end = 55.dp,
                                bottom = 25.dp)
                    ) {
                        Text(
                            text = exploreItem.name,
                            modifier = Modifier,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = exploreItem.place,
                            modifier = Modifier,
                            color = MaterialTheme.colorScheme.primary,
                            fontSize = 10.sp
                        )
                        CustomProgressBar(progress = 50, modifier = Modifier.fillMaxWidth())
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Column (
                        modifier = Modifier
                            .offset(x = 20.dp, y = 100.dp)
                    ){
                        Row {
                            Text(text = exploreItem.P1, fontSize = 14.sp, fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)
                            Text(text = " | ", fontSize = 14.sp)
                            Text(text = exploreItem.P2, fontSize = 14.sp, fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)
                            Text(text = " | ", fontSize = 14.sp)
                            Text(text = exploreItem.P3, fontSize = 14.sp, fontWeight = FontWeight.Bold,color = MaterialTheme.colorScheme.primary)
                        }
                        Text(
                            text = exploreItem.Descp,
                            fontSize = 10.sp,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(end = 80.dp)
                        )
                    }
                }
            }
        )
        Card(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(y = 20.dp)
                .padding(30.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            content = {
                Image(
                    painter = painterResource(exploreItem.path),
                    contentDescription = "picture",
                    modifier = Modifier.size(60.dp)
                )
            }
        )
        var inviteText by remember { mutableStateOf(" + INVITE") }

        CreateClickableText(
            text = remember { mutableStateOf(inviteText) },
            onClick = {
                inviteText = "PENDING"
            },
            modifier = Modifier.fillMaxWidth()
                .offset(x = 260.dp,y = 45.dp)
        )

    }
}

@Composable
fun CreateClickableText(
    text: MutableState<String>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ClickableText(
        text = AnnotatedString(text.value),
        onClick = {
            onClick.invoke()
        },
        modifier = modifier
    )
}

@Composable
fun CustomProgressBar(
    progress: Int,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    require(progress in 0..100) { "Progress should be between 0 and 100." }

    Box(
        modifier = modifier
            .height(8.dp)
            .width(2.dp * progress / 100f)
            .clip(RoundedCornerShape(percent = 50))
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
    ) {
        Box(
            modifier = Modifier
                .height(8.dp)
                .fillMaxSize(progress / 100f)
                .clip(RoundedCornerShape(percent = 50))
                .background(color)
        )
    }
}
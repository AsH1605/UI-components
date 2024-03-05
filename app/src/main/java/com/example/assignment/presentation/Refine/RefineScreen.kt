package com.example.assignment.presentation.Refine

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RefineScreen(){
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        LazyColumn {
            item {
                Text(text = "Select Your Availability", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(10.dp))
                DropDownMenu()
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Add Your Status", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(10.dp))
                MyContent()
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Select Hyper Local Distance", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(10.dp))
                var sliderValue by remember { mutableStateOf(50f) }
                SliderWithLabel(
                    value = sliderValue,
                    valueRange = 0f..100f,
                    finiteEnd = true,
                    onRadiusChange = { newValue ->
                        sliderValue = newValue.toFloatOrNull() ?: 0f
                    }
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Select Purpose", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(10.dp))
                FlowRow(
                    modifier = Modifier.padding(16.dp)
                ) {
                    MyColoredButton(text = "Coffee")
                    MyColoredButton(text = "Business")
                    MyColoredButton(text = "Hobbies")
                    MyColoredButton(text = "Friendship")
                    MyColoredButton(text = "Movies")
                    MyColoredButton(text = "Dining")
                    MyColoredButton(text = "Dating")
                    MyColoredButton(text = "Matrimony")
                }
            }
        }

    }
}

@Composable
fun MyColoredButton(text: String) {
    var buttonState by remember { mutableStateOf(false) }
    Button(
        onClick = { buttonState = !buttonState },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (buttonState) MaterialTheme.colorScheme.primary else Color.White,
            contentColor = if (buttonState) Color.White else MaterialTheme.colorScheme.primary
        ),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)
    ) {
        Text(text = text)
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MyContent(){
    var mText by remember { mutableStateOf(TextFieldValue("Hi community! I am open to new connections")) }
    val mMaxLength = 250
    val mContext = LocalContext.current
    Column(
        Modifier.fillMaxWidth()
    ) {
        FlowRow (modifier = Modifier.padding(4.dp)){
            TextField(
                value = mText,
                onValueChange = {
                    if (it.text.length <= mMaxLength) mText = it
                    else Toast.makeText(mContext, "Cannot be more than 250 Characters", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier.height(100.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.primary
                ),
            )
        }
        Text(text = "${mText.text.length}/${mMaxLength}", modifier = Modifier.align(Alignment.End), fontSize = 15.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(){
    val context = LocalContext.current
    var selectedText by remember { mutableStateOf("Available | Hey Let Us Connect") }
    var expanded by remember {
        mutableStateOf(false)
    }
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterStart)
            .height(60.dp)
            .width(600.dp)
    ){
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange ={
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier
                    .menuAnchor()
                    .align(Alignment.Center),
                textStyle = TextStyle(fontSize = 20.sp, color = MaterialTheme.colorScheme.primary),
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text(text = "Available | Hey Let Us Connect") },
                    onClick = { selectedText = "Available | Hey Let Us Connect"}
                )
                DropdownMenuItem(
                    text = { Text(text = "Away | Stay Discrete And Watch") },
                    onClick = { selectedText = "Away | Stay Discrete And Watch"}
                )
                DropdownMenuItem(
                    text = { Text(text = "Busy | Do Not Disturb | Will Catch Later") },
                    onClick = { selectedText = "Busy | Do Not Disturb | Will Catch Later"}
                )
                DropdownMenuItem(
                    text = { Text(text = "SOS | Emergency! Need Assistance") },
                    onClick = { selectedText = "SOS | Emergency! Need Assistance"}
                )
            }
        }
    }
}

@Composable
fun SliderWithLabel(
    value: Float,
    valueRange: ClosedFloatingPointRange<Float>,
    finiteEnd: Boolean,
    labelMinWidth: Dp = 24.dp,
    onRadiusChange: (String) -> Unit
) {
    Column() {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val offset = getSliderOffset(
                value = value,
                valueRange = valueRange,
                boxWidth = maxWidth,
                labelWidth = labelMinWidth + 8.dp
            )
            val endValueText =
                if (!finiteEnd && value >= valueRange.endInclusive) "${
                    value.toInt()
                }+" else value.toInt().toString()
            if (value > valueRange.start) {
                SliderLabel(
                    label = endValueText, minWidth = labelMinWidth, modifier = Modifier
                        .padding(start = offset)
                )
            }
        }
        Slider(
            value = value, onValueChange = {
                onRadiusChange(it.toString())
            },
            valueRange = valueRange,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "0 Km", fontSize = 16.sp, modifier = Modifier.weight(1f), color = MaterialTheme.colorScheme.primary)
            Text(text = "100 Km", fontSize = 16.sp, color = MaterialTheme.colorScheme.primary)
        }
    }
}


@Composable
fun SliderLabel(label: String, minWidth: Dp, modifier: Modifier = Modifier) {
    Text(
        label,
        textAlign = TextAlign.Center,
        color = Color.White,
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(4.dp)
            .defaultMinSize(minWidth = minWidth)
    )
}


private fun getSliderOffset(
    value: Float,
    valueRange: ClosedFloatingPointRange<Float>,
    boxWidth: Dp,
    labelWidth: Dp
): Dp {

    val coerced = value.coerceIn(valueRange.start, valueRange.endInclusive)
    val positionFraction = calcFraction(valueRange.start, valueRange.endInclusive, coerced)

    return (boxWidth - labelWidth) * positionFraction
}

private fun calcFraction(a: Float, b: Float, pos: Float) =
    (if (b - a == 0f) 0f else (pos - a) / (b - a)).coerceIn(0f, 1f)
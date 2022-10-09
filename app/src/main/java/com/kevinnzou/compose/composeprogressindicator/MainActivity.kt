package com.kevinnzou.compose.composeprogressindicator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kevinnzou.compose.composeprogressindicator.ui.theme.ComposeProgressIndicatorTheme
import com.kevinnzou.compose.progressindicator.SimpleProgressIndicator
import com.kevinnzou.compose.progressindicator.SimpleProgressIndicatorWithAnim

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var progress by remember { mutableStateOf(0f) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text("Simple ProgressIndicator Example", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(20.dp))
            SimpleProgressIndicatorWithAnim(
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .height(4.dp),
                progress,
                cornerRadius = 35.dp,
                thumbRadius = 1.dp,
                thumbOffset = 1.5.dp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .wrapContentWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TextButton(onClick = {
                    progress = (progress - 0.1f).coerceAtLeast(0f)
                }) {
                    Text(text = "Decrease", color = Color.Black)
                }
                TextButton(onClick = {
                    progress = (progress + 0.1f).coerceAtMost(1f)
                }) {
                    Text(text = "Increase", color = Color.Black)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}

@Preview(showBackground = true)
@Composable
fun PreviewSimpleProgressIndicator() {
    ComposeProgressIndicatorTheme {
        SimpleProgressIndicator(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
                .height(4.dp), cornerRadius = 35.dp, thumbRadius = 1.dp, thumbOffset = 1.5.dp,
            progress = 0.8f
        )
    }
}
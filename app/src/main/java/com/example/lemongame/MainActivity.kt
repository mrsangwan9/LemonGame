package com.example.lemongame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemongame.ui.theme.LemonGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonGame()
                }
            }
        }
    }
}

@Composable
fun LemonGame() {
    LemonImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Composable
fun LemonImage(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(1) }
    val selectedImage = when (result) {
        7 -> R.drawable.lemon_drink
        8 -> R.drawable.lemon_restart
        1 -> R.drawable.lemon_tree
        in (2..6) -> R.drawable.lemon_squeeze

        else -> "nothing"
    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        if (result>1 && result < 7) {
            Text(
                text = "squeeze the lemon to lemon drink", modifier = Modifier.padding(bottom = 20.dp),
                fontSize = 22.sp
            )
        }
        Button(onClick = {
            result += 1
            if (result > 8) {
                result = 1
            }
        }) {
            val image = painterResource(selectedImage as Int)

            Image(
                painter = image,
                contentDescription = "image of lemon drink",
            )
        }
    }
}


@Preview(showBackground = false)
@Composable
fun DefaultPreview() {
    LemonGameTheme {
        LemonGame()
    }

}
package com.example.ballfortune

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ballfortune.ui.theme.BallFortuneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BallFortuneTheme {
                BallFortuneApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BallFortuneApp() {
    BallFortune(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}


@Composable
fun BallFortune(modifier: Modifier = Modifier)
{
    val fortunes = listOf(
        "Удача уже на пути!",
        "Ждите великих событий в ближайшем будущем.",
        "Вас ждет приятный сюрприз.",
        "Возможности приходят к вам.",
        "Ваша тяжелая работа скоро окупится"
    )

    var currentFortuneIndex by remember { mutableStateOf(-1) }

    fun generateRandomFortune() {
        currentFortuneIndex = fortunes.indices.random()
    }

    Column(
        modifier = modifier
            .clickable { generateRandomFortune() }
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.fortune_ball),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )

        Text(
            text = if (currentFortuneIndex != -1) fortunes[currentFortuneIndex] else "Нажмите, чтобы узнать свое предсказание",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}
package com.paligot.a11y.text.skipped

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paligot.a11y.text.skipped.ui.theme.A11ytextskippedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A11ytextskippedTheme {
                Screen()
            }
        }
    }
}

@Composable
fun Screen() {
    Scaffold {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                Item(
                    time = "10:00",
                    items = arrayListOf(
                        "Technically Speaking: improve your code with documentation",
                        "Ahead Of Time et Native avec Spring Boot 3.0",
                        "Getting started with mobile accessibility: iOS, Android, and Flutter"
                    )
                )
            }
            item {
                ItemOneTalk(
                    time = "10:00",
                    item = "Technically Speaking: improve your code with documentation"
                )
            }
            item {
                ItemOneTalk(
                    item = "Ahead Of Time et Native avec Spring Boot 3.0"
                )
            }
            item {
                ItemOneTalk(
                    item = "Getting started with mobile accessibility: iOS, Android, and Flutter"
                )
            }
        }
    }
}

@Composable
fun Item(
    time: String,
    items: List<String>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Text(
            text = time,
            modifier = Modifier.width(timeSpace)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach {
                Box(modifier = modifier.clickable(onClick = { })) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(start = timeSpace)
                    )
                }
            }
        }
    }
}

@Composable
fun ItemOneTalk(
    item: String,
    modifier: Modifier = Modifier,
    time: String? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = { })
    ) {
        time?.let {
            Text(
                text = time,
                modifier = Modifier
                    .width(timeSpace)
            )
        }
        Text(
            text = item,
            modifier = if (time == null) Modifier.padding(start = timeSpace) else Modifier
        )
    }
}

val timeSpace = 55.dp

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    A11ytextskippedTheme {
        Screen()
    }
}
package com.paulklauser.catfacts.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.paulklauser.catfacts.SharedViewModel
import com.paulklauser.catfacts.UiState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Scaffold { paddingValues ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        val vm: SharedViewModel = viewModel()
                        val uiState by vm.uiState.collectAsState()
                        MainScreen(
                            uiState = uiState,
                            onGetCatFact = vm::fetchCatFact
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    onGetCatFact: () -> Unit,
    uiState: UiState
) {
    Column {
        when (uiState) {
            is UiState.Loading -> Text(text = "Loading...")
            is UiState.Initial -> Text(text = "Press the button to get a cat fact")
            is UiState.Success -> Text(text = "Cat Fact: ${uiState.catFact}")
        }
        Button(onClick = onGetCatFact) {
            Text("Get Cat Fact")
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MainScreen(
            onGetCatFact = {},
            uiState = UiState.Initial
        )
    }
}

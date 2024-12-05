package com.hackernews.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hackernews.HackerNewsViewModel
import com.hackernews.ui.components.HackerNewsItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(hackerNewsViewModel: HackerNewsViewModel = viewModel()) {
    // Collect the state of HackerNews from the view model
    val hackerNews by hackerNewsViewModel.hackerNewsState.collectAsState()

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "HackerNews"
                        )
                    },
                    actions = {
                        // Refresh button
                        IconButton(
                            onClick = hackerNewsViewModel::refresh
                        ) {
                            Icon(
                                Icons.Filled.Refresh,
                                contentDescription = "Refresh"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentPadding = PaddingValues(vertical = 12.dp),
            ) {
                itemsIndexed(
                    items = hackerNews,
                ) { _, item ->
                    // Display each HackerNews item
                    HackerNewsItem(
                        item,
                        onRemove = hackerNewsViewModel::removeItem
                    )
                }
            }
        }
    }
}
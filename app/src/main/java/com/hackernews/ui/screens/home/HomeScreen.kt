package com.hackernews.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hackernews.ui.screens.home.components.HackerNewsItem
import com.hackernews.ui.screens.home.components.PullToRefreshLazyColumn
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(hackerNewsViewModel: HomeViewModel = viewModel()) {
    // Collect the state of HackerNews from the view model
    val hackerNews by hackerNewsViewModel.hackerNewsState.collectAsState()

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            var isRefreshing by remember {
                mutableStateOf(false)
            }
            val scope = rememberCoroutineScope()

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                PullToRefreshLazyColumn(
                    items = hackerNews,
                    content = { item ->
                        // Display each HackerNews item
                        HackerNewsItem(
                            item,
                            onRemove = hackerNewsViewModel::removeItem
                        )
                    },
                    isRefreshing = isRefreshing,
                    onRefresh = {
                        scope.launch {
                            isRefreshing = true
                            delay(1000L) // Simulated API call
                            hackerNewsViewModel::refresh
                            isRefreshing = false
                        }
                    }
                )
            }
        }
    }
}
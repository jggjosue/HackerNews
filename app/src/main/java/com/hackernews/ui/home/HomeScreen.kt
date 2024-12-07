package com.hackernews.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.hackernews.network.model.HackerNews
import com.hackernews.network.model.hackerNewsList
import com.hackernews.ui.screens.Screen
import com.hackernews.ui.home.components.HackerDetailHomeItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onHackerNewsClick: (HackerNews) -> Unit
) {
    Screen {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        Scaffold(
            topBar = {},
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
        ) { padding ->
            LazyVerticalGrid(
                columns = GridCells.Adaptive(240.dp),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(padding)
            ) {
                items(hackerNewsList, key = { it.id }) {
                    HackerDetailHomeItem(hackerNews = it, onClick = { onHackerNewsClick(it) })
                }
            }
        }
    }
}
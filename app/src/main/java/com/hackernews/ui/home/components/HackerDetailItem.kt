package com.hackernews.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hackernews.network.model.HackerNews

/**
 * Composable that represents a single HackerNews
 *
 * @param hackerNews The HackerNews to display.
 */
@Composable
fun HackerDetailHomeItem(
    hackerNews: HackerNews,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Text(
            text = hackerNews.name,
            style = MaterialTheme.typography.titleMedium,
            maxLines = 1,
            modifier = Modifier.padding(1.dp)
        )
        Text(
            text = hackerNews.message,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            modifier = Modifier.padding(1.dp)
        )
    }
}
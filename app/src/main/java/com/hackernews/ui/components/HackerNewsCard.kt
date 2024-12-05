package com.hackernews.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.hackernews.HackerNews

/**
 * Composable that represents a single HackerNews
 *
 * @param hackerNews The HackerNews to display.
 */
@Composable
fun HackerNewsCard(hackerNews: HackerNews) {
    ListItem(
        modifier = Modifier.clip(MaterialTheme.shapes.small),
        headlineContent = {
            Text(
                hackerNews.name,
                style = MaterialTheme.typography.titleMedium
            )
        },
        supportingContent = {
            Text(
                hackerNews.message,
                style = MaterialTheme.typography.bodySmall
            )
        },
    )
}
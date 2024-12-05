package com.hackernews.ui.components

import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue.EndToStart
import androidx.compose.material3.SwipeToDismissBoxValue.Settled
import androidx.compose.material3.SwipeToDismissBoxValue.StartToEnd
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.hackernews.HackerNews

/**
 * Composable representing an hackerNews item with swipe-to-dismiss functionality.
 *
 * @param hackerNews The hackerNews to display.
 * @param modifier optional parameters to add extra behaviour to hackerNews.
 * @param onRemove Callback invoked when the hackerNews item is dismissed.
 */
@Composable
fun HackerNewsItem(
    hackerNews: HackerNews,
    modifier: Modifier = Modifier,
    onRemove: (HackerNews) -> Unit
) {
    val context = LocalContext.current
    val currentItem by rememberUpdatedState(hackerNews)
    val dismissState = rememberSwipeToDismissBoxState(
        confirmValueChange = {
            when(it) {
                EndToStart -> {
                    onRemove(currentItem)
                }
                StartToEnd -> {
                    onRemove(currentItem)
                }
                Settled -> return@rememberSwipeToDismissBoxState false
            }
            return@rememberSwipeToDismissBoxState true
        },
        // positional threshold of 25%
        positionalThreshold = { it * .25f }
    )
    SwipeToDismissBox(
        state = dismissState,
        modifier = modifier,
        backgroundContent = {
            DismissBackground(dismissState)
        },
        content = {
            HackerNewsCard(hackerNews)
        }
    )
}
package com.hackernews.ui.home.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue.EndToStart
import androidx.compose.material3.SwipeToDismissBoxValue.Settled
import androidx.compose.material3.SwipeToDismissBoxValue.StartToEnd
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import com.hackernews.network.model.HackerNews

/**
 * Composable representing an hackerNews item with swipe-to-dismiss functionality.
 *
 * @param hackerNews The hackerNews to display.
 * @param modifier optional parameters to add extra behaviour to hackerNews.
 * @param onRemove Callback invoked when the hackerNews item is dismissed.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HackerNewsItem(
    hackerNews: HackerNews,
    modifier: Modifier = Modifier,
    onRemove: (HackerNews) -> Unit,
    onClick: () -> Unit
) {
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
//            HackerNewsCard(
//                hackerNews = hackerNews,
//                onClick = onClick
//            )
        }
    )
}
package com.hackernews.ui.home

import androidx.lifecycle.ViewModel
import com.hackernews.network.model.HackerNews
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    // StateFlow to hold the list of HackerNews
    private val _hackerNewsState = MutableStateFlow(emptyList<HackerNews>())
    val hackerNewsState: StateFlow<List<HackerNews>> = _hackerNewsState.asStateFlow()

    init {
        // Initialize the list of HackerNews
        // when the ViewModel is created
        _hackerNewsState.update { getHackerNews() }
    }

    /**
     * Refreshes the list of HackerNews
     */
    fun refresh() {
        _hackerNewsState.update {
            getHackerNews()
        }
    }

    /**
     * Removes HackerNews from the list.
     * @param currentItem The HackerNews to be removed.
     */
    fun removeItem(currentItem: HackerNews) {
        _hackerNewsState.update {
            val mutableList = it.toMutableList()
            mutableList.remove(currentItem)
            mutableList
        }
    }

    /**
     * Generates a list of sample HackerNews
     * @return The list of sample HackerNews
     */
    fun getHackerNews() = listOf(
        HackerNews(
            id = "1",
            "daghamm",
            "DOJ will push Google to sell off Chrome.",
            "https://www.bloomberg.com/news/articles/2024-11-18/doj-will-push-google-to-sell-off-chrome-to-break-search-monopoly"
        ),
    )
}
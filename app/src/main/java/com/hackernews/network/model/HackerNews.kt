package com.hackernews.network.model

data class HackerNews(
    val id: String,
    val message: String,
    val name: String,
    val webView: String
)

val hackerNewsList = (1 .. 10).map {
    HackerNews(
        id = "$it",
        "daghamm $it",
        "DOJ will push Google to sell off Chrome $it",
        "https://www.bloomberg.com/news/articles/2024-11-18/doj-will-push-google-to-sell-off-chrome-to-break-search-monopoly"
    )
}
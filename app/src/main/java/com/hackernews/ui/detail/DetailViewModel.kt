package com.hackernews.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackernews.network.model.HackerNews
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val id: Int) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    data class UiState(
        val loading: Boolean = false,
        val hackerNews: HackerNews? = null
    )

    init {
        viewModelScope.launch {
            _state.value = UiState(loading = true)
            /*repository.fetchMovieById(id).collect {
                it?.let { _state.value = UiState(loading = false, movie = it) }
            }*/
        }
    }

    fun onFavoriteClick() {
        _state.value.hackerNews?.let {
            viewModelScope.launch {
                //repository.toggleFavorite(it)
            }
        }
    }
}
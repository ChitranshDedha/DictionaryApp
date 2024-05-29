package com.example.dictionary_app.data.presentation

import com.example.dictionary_app.data.domain.model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val searchWord : String ="",
    val wordItem: WordItem? =null
)

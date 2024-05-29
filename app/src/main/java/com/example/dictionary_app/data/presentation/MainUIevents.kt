package com.example.dictionary_app.data.presentation

sealed class  MainUIevents {
    data class OnSearchWordChange(
        val newWord:String
    ):MainUIevents()

    object OnSearchClick : MainUIevents()
}
package com.example.dictionary_app.data.dto

data class WordItemDto(

    val meanings: List<MeaningDto>,
    val phonetic: String,
    val word: String
)
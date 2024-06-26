package com.example.dictionary_app.data.dto

data class MeaningDto(
    val antonyms: List<Any>?,
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String,
    val synonyms: List<String>?,
    )
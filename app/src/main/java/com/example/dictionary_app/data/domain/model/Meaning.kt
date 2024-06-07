package com.example.dictionary_app.data.domain.model

data class Meaning(
    val antonyms: List<Any>,
    val definition: Definition,
    val partOfSpeech: String,
    val synonyms: List<String>,
)

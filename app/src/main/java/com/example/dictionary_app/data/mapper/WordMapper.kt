package com.example.dictionary_app.data.mapper

import com.example.dictionary_app.data.domain.model.Definition
import com.example.dictionary_app.data.domain.model.Meaning
import com.example.dictionary_app.data.domain.model.WordItem
import com.example.dictionary_app.data.dto.DefinitionDto
import com.example.dictionary_app.data.dto.MeaningDto
import com.example.dictionary_app.data.dto.WordItemDto

fun WordItemDto.toWordItem() = WordItem (
    word = word ?: "",
    meanings = meanings?.map {
        it.toMeaning()
    } ?: emptyList(),
    phonetic = phonetic ?: ""
)

fun MeaningDto.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech ?: "",
    antonyms = antonyms ?: emptyList(),
    synonyms = synonyms?: emptyList()
)


fun definitionDtoToDefinition(
    definitionDto: DefinitionDto?
) = Definition(
    definition = definitionDto?.definition ?: "",
    example = definitionDto?.example ?: "",
)
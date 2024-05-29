package com.example.dictionary_app.data.domain.repositary

import com.example.dictionary_app.data.domain.model.WordItem
import com.example.dictionary_app.data.util.Result
import kotlinx.coroutines.flow.Flow



interface DictionaryRepositary {
    suspend fun getWordResult(
        word: String
    ):Flow<Result<WordItem>>

}
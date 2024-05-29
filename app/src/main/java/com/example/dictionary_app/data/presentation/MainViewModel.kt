package com.example.dictionary_app.data.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionary_app.data.domain.repositary.DictionaryRepositary
import com.example.dictionary_app.data.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dictionaryRepositary: DictionaryRepositary
):ViewModel() {
    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    private val searchJob : Job?=null
    fun onEvent(mainEvent : MainUIevents){
        when(mainEvent){
            MainUIevents.OnSearchClick ->{
                loadWordResult()
            }
            is MainUIevents.OnSearchWordChange -> {
                _mainState.update {
                    it.copy(
                        searchWord = mainEvent.newWord.lowercase()
                    )
                }
            }
        }
    }
    private fun loadWordResult(){
        viewModelScope.launch {
            dictionaryRepositary.getWordResult(
                mainState.value.searchWord
            ).collect{ result ->
                when(result){
                    is Result.Error -> Unit
                    is Result.Loading -> {
                        _mainState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }
                    is Result.Success -> {
                        result.data?.let { wordItem ->
                            _mainState.update {
                                it.copy(
                                    wordItem = wordItem
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}
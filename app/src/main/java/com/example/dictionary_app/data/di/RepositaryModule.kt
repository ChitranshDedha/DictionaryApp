package com.example.dictionary_app.data.di


import com.example.dictionary_app.data.domain.repositary.DictionaryRepositary
import com.example.dictionary_app.data.repositary.DictionaryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDictionaryRepository(
        dictionaryRepositoryImpl: DictionaryRepositoryImpl
    ):DictionaryRepositary

}
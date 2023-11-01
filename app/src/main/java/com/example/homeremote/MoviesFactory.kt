package com.example.homeremote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MoviesFactory (
    private val moviesApiService: MoviesApiService,
    private val moviesDatabase: MoviesDatabase
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesViewModel(moviesApiService, moviesDatabase) as T
    }
}
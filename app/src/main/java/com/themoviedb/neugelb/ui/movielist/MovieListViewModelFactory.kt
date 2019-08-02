package com.themoviedb.neugelb.ui.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.themoviedb.neugelb.domain.movielist.MovieListUseCase
import timber.log.Timber
import javax.inject.Inject

/**
 * Factory for ViewModels
 */
class MovieListViewModelFactory @Inject constructor(private val movieListUseCase: MovieListUseCase) : ViewModelProvider.Factory {
    init{
        Timber.d("init")
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieListViewModel(movieListUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
package com.themoviedb.neugelb.ui.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.themoviedb.neugelb.domain.moviedetail.MovieDetailUseCase
import javax.inject.Inject


/**
 * Factory for ViewModels
 */
class MovieDetailViewModelFactory @Inject constructor(private val movieDetailUseCase: MovieDetailUseCase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MovieDetailViewModel(movieDetailUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
package com.themoviedb.neugelb.ui.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.themoviedb.neugelb.domain.entity.Movie
import com.themoviedb.neugelb.domain.moviedetail.MovieDetailUseCase
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val movieDetailUseCase : MovieDetailUseCase) : ViewModel() {
    private val _movieId = MutableLiveData<Long>()

    val movie : LiveData<Movie> = Transformations
        .switchMap(_movieId) { id ->
            movieDetailUseCase.getMovie(id)
        }

    fun setMovieId(id : Long){
        // We need the movie data only once. If it's already there no need to set id again as it
        // will force to get the data again fron the database. This check is helpful in case of
        // configuration changes as we call setMovieId from fragment.
        if(_movieId.value != id) {
            _movieId.value = id
        }
    }
}
package com.themoviedb.neugelb.domain.moviedetail

import androidx.lifecycle.LiveData
import com.themoviedb.neugelb.domain.Logger
import com.themoviedb.neugelb.domain.entity.Movie
import javax.inject.Inject

class MovieDetailUseCase @Inject constructor(private val repository: MovieDetailRepository, private val log : Logger){
    fun getMovie(id : Long): LiveData<Movie> {
        return repository.getMovie(id)
    }
}
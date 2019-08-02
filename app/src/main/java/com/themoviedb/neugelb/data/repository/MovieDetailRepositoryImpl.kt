package com.themoviedb.neugelb.data.repository

import androidx.lifecycle.LiveData
import com.themoviedb.neugelb.domain.entity.Movie
import com.themoviedb.neugelb.domain.moviedetail.MovieDetailRepository
import javax.inject.Inject


class MovieDetailRepositoryImpl @Inject constructor(
    private val localData: LocalData
) : MovieDetailRepository {
    override
    fun getMovie(id : Long): LiveData<Movie> {
        return localData.getMovie(id)
    }
}

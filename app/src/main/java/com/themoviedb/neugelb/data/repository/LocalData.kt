package com.themoviedb.neugelb.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.themoviedb.neugelb.data.MovieData
import com.themoviedb.neugelb.domain.entity.Movie
import com.themoviedb.neugelb.domain.entity.MoviePoster
import com.themoviedb.neugelb.domain.vo.BoundaryState
import java.util.*

// This interface is in accordance to Dependency Inversion Principle by separating the higher
// repository class from lower database class.
interface LocalData {

    fun getMovies() : LiveData<PagedList<MoviePoster>>
    fun getBoundaryState(): LiveData<BoundaryState<Date>>
    fun insertMovies(movies: List<MovieData>)
    fun deleteMovies()
    fun refresh()

    fun getMovie(id : Long) : LiveData<Movie>
}
package com.themoviedb.neugelb.data.database

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.themoviedb.neugelb.AppExecutors
import com.themoviedb.neugelb.data.MovieData
import com.themoviedb.neugelb.data.repository.LocalData
import com.themoviedb.neugelb.domain.entity.Movie
import com.themoviedb.neugelb.domain.entity.MoviePoster
import com.themoviedb.neugelb.domain.vo.BoundaryState
import java.util.*
import javax.inject.Inject

class LocalDataImpl @Inject constructor(private val appExecutors: AppExecutors,
                                        private val movieDao: MovieDao) :
    LocalData {
    private val boundaryCallback =
        MovieBoundaryCallback()

    override fun getMovies(): LiveData<PagedList<MoviePoster>> {
        val dataSourceFactory = movieDao.getDataSourcefactory()
        return LivePagedListBuilder(dataSourceFactory, MovieBoundaryCallback.DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()
    }

    override fun getMovie(id : Long): LiveData<Movie> {
        return movieDao.getMovie(id)
    }

    override fun getBoundaryState(): LiveData<BoundaryState<Date>> {
        return boundaryCallback.boundaryState
    }

    override fun insertMovies(movies: List<MovieData>) {
        appExecutors.diskIO().execute {
            movieDao.insertMovies(movies)
        }
    }

    override fun deleteMovies() {
        movieDao.deleteMovies()
    }

    override fun refresh() {
        boundaryCallback.refresh()
    }
}
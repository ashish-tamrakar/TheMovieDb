package com.themoviedb.neugelb.data.database

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.themoviedb.neugelb.data.MovieData
import com.themoviedb.neugelb.domain.entity.Movie
import com.themoviedb.neugelb.domain.entity.MoviePoster

@Dao
interface MovieDao {

    @Query("SELECT id, title, posterPath, releaseDate, voteAverage  FROM movies ORDER BY releaseDate DESC, title ASC")
    fun getDataSourcefactory(): DataSource.Factory<Int, MoviePoster>

    @Query("SELECT * FROM movies WHERE id= :id")
    fun getMovie(id: Long) : LiveData<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieData>)

    @Query("DELETE FROM movies")
    fun deleteMovies()
}
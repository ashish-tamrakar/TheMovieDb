package com.themoviedb.neugelb.data.network

import com.themoviedb.neugelb.data.MovieData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {

    @GET("discover/movie?certification_country=US&adult=false&with_original_language=en&sort_by=primary_release_date.desc")
    fun getMovies(
        @Query("primary_release_date.lte") releaseDate: String
    ): Call<List<MovieData>>
}

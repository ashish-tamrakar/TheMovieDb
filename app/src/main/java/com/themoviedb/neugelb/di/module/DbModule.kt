package com.themoviedb.neugelb.di.module

import android.app.Application
import androidx.room.Room
import com.themoviedb.neugelb.data.database.MovieDb
import com.themoviedb.neugelb.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class DbModule(){

    @Provides
    @ApplicationScope
    fun provideMovieDb(application: Application) =
        Room.databaseBuilder(
            application,
            MovieDb::class.java, "movie.db"
        ).build()

    @Provides
    @ApplicationScope
    fun provideMovieDao(movieDb: MovieDb) = movieDb.movieDao()
}
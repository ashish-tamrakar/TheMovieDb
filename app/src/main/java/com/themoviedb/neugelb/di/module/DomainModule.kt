package com.themoviedb.neugelb.di.module

import com.themoviedb.neugelb.data.repository.MovieDetailRepositoryImpl
import com.themoviedb.neugelb.data.repository.MovieListRepositoryImpl
import com.themoviedb.neugelb.di.scope.FragmentScope
import com.themoviedb.neugelb.domain.moviedetail.MovieDetailRepository
import com.themoviedb.neugelb.domain.movielist.MovieListRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule{

    @Binds
    @FragmentScope
    fun bindMovieListRepository(movieListRepository : MovieListRepositoryImpl) : MovieListRepository

    @Binds
    @FragmentScope
    fun bindMovieDetailRepository(movieDetailRepository : MovieDetailRepositoryImpl) : MovieDetailRepository
}
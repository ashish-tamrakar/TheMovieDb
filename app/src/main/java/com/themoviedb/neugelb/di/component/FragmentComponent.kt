package com.themoviedb.neugelb.di.component

import com.themoviedb.neugelb.di.module.DataModule
import com.themoviedb.neugelb.di.module.DomainModule
import com.themoviedb.neugelb.di.scope.FragmentScope
import com.themoviedb.neugelb.ui.moviedetail.MovieDetailFragment
import com.themoviedb.neugelb.ui.movielist.MovieListFragment
import dagger.Subcomponent

@Subcomponent(modules = [DataModule::class, DomainModule::class])
@FragmentScope
interface FragmentComponent{
    fun inject(movieListFragment: MovieListFragment)
    fun inject(movieDetailFragment: MovieDetailFragment)
}
package com.themoviedb.neugelb.domain.movielist

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.themoviedb.neugelb.domain.entity.MoviePoster
import com.themoviedb.neugelb.domain.vo.BoundaryState
import com.themoviedb.neugelb.domain.vo.LoadingStatus
import java.util.*

// As we need to interact with repostiory which is in data layer. Implementing Dependency Inversion
// Principle we create an interface which concrete respository class in data layer implements.
// This way we remove any dependency on data layer from domain layer
interface MovieListRepository {
    fun getMovies(): LiveData<PagedList<MoviePoster>>
    fun getBoundaryState(): LiveData<BoundaryState<Date>>
    fun fetchMore(fetchDate: Date, predicate: (String?) -> (Boolean)) : LiveData<LoadingStatus>
    fun returnLoadingOrSuccess() : LiveData<LoadingStatus>
    fun refresh()
}
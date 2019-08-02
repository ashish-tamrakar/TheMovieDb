package com.themoviedb.neugelb.ui.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.themoviedb.neugelb.domain.movielist.MovieListUseCase
import com.themoviedb.neugelb.domain.vo.Direction
import com.themoviedb.neugelb.domain.vo.LoadingStatus
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val movieListUseCase: MovieListUseCase) : ViewModel() {
    val movies = movieListUseCase.getMovies()

    //PagedList use BoundaryCallback object to send us callback about necessary events related to
    // data loading. Here we capture those events and fetch data from the network. The
    // movieListUseCase.fetchMore() function returns loading status which we observe in UI to
    // show progress bar.
    val loadingStatus : LiveData<LoadingStatus> = Transformations.switchMap(
        movieListUseCase.getBoundaryState()) {onBoundaryItemLoaded(it.itemData, it.direction)}

    private fun onBoundaryItemLoaded(itemDate: Date, direction: Direction) : LiveData<LoadingStatus> {
        Timber.d("onBoundaryItemLoaded %s %s ", itemDate, direction)
        return movieListUseCase.fetchMore(itemDate, direction)
    }

    fun refresh() {
        Timber.d("refreshing")
        movieListUseCase.refresh()
    }
}
package com.themoviedb.neugelb.data.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.themoviedb.neugelb.domain.entity.MoviePoster
import com.themoviedb.neugelb.domain.vo.BoundaryState
import timber.log.Timber
import java.util.*

class MovieBoundaryCallback : PagedList.BoundaryCallback<MoviePoster>() {

    private val _boundaryState = MutableLiveData<BoundaryState<Date>>()
    val boundaryState : LiveData<BoundaryState<Date>>
        get() = _boundaryState

    companion object {
        const val DATABASE_PAGE_SIZE = 15
    }

    override fun onItemAtFrontLoaded(itemAtFront: MoviePoster) {
        Timber.d(
            "onItemAtFrontLoaded %d %s %s ", itemAtFront.id,
            itemAtFront.title, itemAtFront.hashCode()
        )
        _boundaryState.value = BoundaryState.itemLoadedAtTop(itemAtFront.releaseDate)
    }

    override fun onZeroItemsLoaded() {
        Timber.d("onZeroItemsLoaded")
        _boundaryState.value = BoundaryState.zeroItemsLoaded(Date())
    }

    override fun onItemAtEndLoaded(itemAtEnd: MoviePoster) {
        Timber.d(
            "onItemAtFrontLoaded %d %s %s ", itemAtEnd.id,
            itemAtEnd.title, itemAtEnd.hashCode()
        )
        _boundaryState.value = BoundaryState.itemLoadedAtBottom(itemAtEnd.releaseDate)
    }

    fun refresh(){
        Timber.d("refresh")
        _boundaryState.value = BoundaryState.zeroItemsLoaded(Date())
    }

}
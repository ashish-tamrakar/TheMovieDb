package com.themoviedb.neugelb.data.repository

import com.themoviedb.neugelb.data.MovieData
import com.themoviedb.neugelb.domain.vo.LoadingStatus
import java.util.*

// This interface is in accordance to Dependency Inversion Principle by separating the higher
// repository class from lower network class.
interface RemoteData {
    fun fetchItems(fetchDate : Date,
                   onSuccess: (movies : List<MovieData>) -> Unit,
                   onStatus: (status : LoadingStatus) -> Unit)
}
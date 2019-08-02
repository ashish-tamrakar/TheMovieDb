package com.themoviedb.neugelb.ui.movielist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.themoviedb.neugelb.R
import com.themoviedb.neugelb.domain.ResourceUrl
import com.themoviedb.neugelb.domain.entity.MoviePoster
import com.themoviedb.neugelb.ui.getReadable
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_movie.*


class MovieListViewHolder(override val containerView: View) :
    androidx.recyclerview.widget.RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(movie: MoviePoster?, listener: (Long) -> Unit) {
        if (movie != null) {
            with(movie) {
                moviePoster.contentDescription = title
                Picasso.get().load(ResourceUrl.getPosterUrl(posterPath)).resize(200, 250)
                    .placeholder(R.drawable.poster_placeholder).into(moviePoster)
                itemView.setOnClickListener { listener.invoke(this.id) }
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup): MovieListViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
            return MovieListViewHolder(view)
        }
    }
}
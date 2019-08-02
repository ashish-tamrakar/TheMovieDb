package com.themoviedb.neugelb.ui.moviedetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import com.themoviedb.neugelb.MovieSampleApp
import com.themoviedb.neugelb.domain.ResourceUrl
import com.themoviedb.neugelb.domain.entity.Movie
import com.themoviedb.neugelb.ui.MainActivity
import com.themoviedb.neugelb.ui.getReadable
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import javax.inject.Inject

class MovieDetailFragment : androidx.fragment.app.Fragment() {
    @Inject
    lateinit var movieDetailViewModelFactory: MovieDetailViewModelFactory

    override fun onAttach(context: Context?) {
        MovieSampleApp.instance.getApplicationComponent().plusFragmentComponent().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(com.themoviedb.neugelb.R.layout.fragment_movie_detail, container, false)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            activity?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val movieDetailViewModel = ViewModelProviders.of(
                this, movieDetailViewModelFactory)
                .get(MovieDetailViewModel::class.java)

        showBackButton()

        movieDetailViewModel.movie.observe(viewLifecycleOwner, Observer { it ->
            it?.let { setMovieData(it) }
        })

        val params = MovieDetailFragmentArgs.fromBundle(arguments)
        movieDetailViewModel.setMovieId(params.movieId.toLong())
    }

    private fun showBackButton() {
        if (activity is MainActivity) {
            (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setMovieData(movie: Movie) {
        activity?.title = movie.title
        title.text = movie.title
        overview.text = movie.overview

        movie.posterPath.let {
            backdrop.visibility = View.VISIBLE
            Picasso.get().load(ResourceUrl.getPosterUrl(movie.posterPath))
                    .placeholder(com.themoviedb.neugelb.R.drawable.poster_placeholder).into(backdrop)
        }

        Picasso.get().load(ResourceUrl.getPosterUrl(movie.posterPath))
                .placeholder(com.themoviedb.neugelb.R.drawable.poster_placeholder).into(poster)
        releaseDate.text = movie.releaseDate.getReadable()
    }
}


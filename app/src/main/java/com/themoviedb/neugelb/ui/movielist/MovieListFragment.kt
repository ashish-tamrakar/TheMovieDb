package com.themoviedb.neugelb.ui.movielist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.themoviedb.neugelb.MovieSampleApp
import com.themoviedb.neugelb.R
import com.themoviedb.neugelb.domain.vo.ErrorCode
import com.themoviedb.neugelb.domain.vo.Status
import com.themoviedb.neugelb.toast
import com.themoviedb.neugelb.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_movie_list.*
import javax.inject.Inject

class MovieListFragment : androidx.fragment.app.Fragment() {
    private lateinit var movieListAdapter: MovieListAdapter
    @Inject
    lateinit var movieListViewModelFactory: MovieListViewModelFactory

    companion object {
        private const val COL = 2
    }

    override fun onAttach(context: Context?) {
        MovieSampleApp.instance.getApplicationComponent().plusFragmentComponent().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.title = getString(R.string.app_name)
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val movieListViewModel = ViewModelProviders.of(
                this, movieListViewModelFactory)
                .get(MovieListViewModel::class.java)

        movieListAdapter = MovieListAdapter {
            NavHostFragment.findNavController(this)
                    .navigate(MovieListFragmentDirections.actionNext(it.toString()))
        }

        movieList.apply {
            setHasFixedSize(true)
            layoutManager = androidx.recyclerview.widget.GridLayoutManager(activity, COL)
            adapter = movieListAdapter
        }
        movieListViewModel.movies.observe(viewLifecycleOwner, Observer { list ->
            movieListAdapter.submitList(list)
        })

        movieListViewModel.loadingStatus.observe(viewLifecycleOwner, Observer { loadingStatus ->
            when {
                loadingStatus?.status == Status.LOADING -> loadingProgress.visibility = View.VISIBLE
                loadingStatus?.status == Status.SUCCESS -> {
                    loadingProgress.visibility = View.INVISIBLE
                    toggleRefreshing(false)
                }
                loadingStatus?.status == Status.ERROR -> {
                    loadingProgress.visibility = View.INVISIBLE
                    toggleRefreshing(false)
                    showErrorMessage(loadingStatus.errorCode, loadingStatus.message)
                }
            }
        })

        swipeRefreshLayout.setOnRefreshListener {
            movieListViewModel.refresh()
        }
    }

    fun hideBackButton() {
        if (activity is MainActivity) {
            (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
    }

    override fun onResume() {
        super.onResume()
        hideBackButton()
    }

    private fun toggleRefreshing(refreshing: Boolean) {
        swipeRefreshLayout.isRefreshing = refreshing
    }

    private fun showErrorMessage(errorCode: ErrorCode?, message: String?) {
        when (errorCode) {
            ErrorCode.NO_DATA -> activity!!.toast(getString(R.string.error_no_data))
            ErrorCode.NETWORK_ERROR -> activity!!.toast(getString(R.string.error_network, message))
            ErrorCode.UNKNOWN_ERROR -> activity!!.toast(getString(R.string.error_unknown, message))
        }
    }
}


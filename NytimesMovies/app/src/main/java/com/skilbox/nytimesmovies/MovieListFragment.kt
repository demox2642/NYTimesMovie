package com.skilbox.nytimesmovies

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.skilbox.nytimesmovies.adapter.MovieListAdapter
import com.skilbox.nytimesmovies.databinding.FragmentMovieListBinding
import com.skilbox.nytimesmovies.plugins.ViewBindingFragment
import com.skilbox.nytimesmovies.vm.MovieViewModel
import kotlinx.coroutines.flow.collectLatest

class MovieListFragment : ViewBindingFragment<FragmentMovieListBinding>(FragmentMovieListBinding::inflate) {

    private var movieAdapter: MovieListAdapter ? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        initViewModel()
    }

    private fun initList() {
        movieAdapter = MovieListAdapter()

        with(binding.moviesRecycler) {
            adapter = movieAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            viewModel.getListData().collectLatest {
                movieAdapter!!.submitData(it)
            }
        }
    }
}

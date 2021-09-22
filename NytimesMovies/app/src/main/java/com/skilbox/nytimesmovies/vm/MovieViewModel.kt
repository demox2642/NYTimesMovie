package com.skilbox.nytimesmovies.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.skilbox.nytimesmovies.Movie
import kotlinx.coroutines.flow.Flow

class MovieViewModel : ViewModel() {

    fun getListData(): Flow<PagingData<Movie>> {

        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { MovieRepository() }
        ).flow.cachedIn(viewModelScope)
    }
}

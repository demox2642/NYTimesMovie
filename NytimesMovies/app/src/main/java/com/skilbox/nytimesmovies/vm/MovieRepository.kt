package com.skilbox.nytimesmovies.vm

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.skilbox.nytimesmovies.BuildConfig
import com.skilbox.nytimesmovies.Movie
import com.skilbox.nytimesmovies.plugins.network.NetworkRetrofit

class MovieRepository : PagingSource<Int, Movie>() {

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextOffset: Int = params.key ?: FIRST_OFFSET_INDEX
            val response = NetworkRetrofit.movieReviewsAPI.getDataFromAPI(nextOffset, BuildConfig.API_KEY)
            val prevOffset = if (nextOffset == 0) null else nextOffset - OFFSET_STEP

            LoadResult.Page(
                data = response.results,
                prevKey = prevOffset,
                nextKey = nextOffset.plus(OFFSET_STEP)
            )
        } catch (e: Exception) {
            Log.e("MovieRepository", "Exception:$e")
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_OFFSET_INDEX = 0
        private const val OFFSET_STEP = 20
    }
}

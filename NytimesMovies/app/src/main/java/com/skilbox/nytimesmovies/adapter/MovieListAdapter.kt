package com.skilbox.nytimesmovies.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skilbox.nytimesmovies.Movie
import com.skilbox.nytimesmovies.R
import kotlinx.android.synthetic.main.movie_vie_for_list.view.*

class MovieListAdapter :
    PagingDataAdapter<Movie, MovieListAdapter.MovieViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_vie_for_list, parent, false)

        return MovieViewHolder(inflater)
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: Movie) {
            itemView.movie_title.text = data.display_title
            itemView.movie_summary_short.text = data.summary_short

            Glide.with(itemView.movie_image)
                .load(data.multimedia.src)
                .placeholder(R.drawable.nytimes_logo)
                .into(itemView.movie_image)
                .view
        }
    }

    class DiffUtilCallBack : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.display_title == newItem.display_title
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}

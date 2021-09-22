package com.skilbox.nytimesmovies

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(
    val display_title: String,
    val summary_short: String,
    val multimedia: Multimedia
)

@JsonClass(generateAdapter = true)
data class Multimedia(
    val src: String?
)

@JsonClass(generateAdapter = true)
data class MovieList(
    val status: String?,
    val copyrightString: String?,
    val has_more: Boolean?,
    val num_results: String?,
    val results: List<Movie>
)

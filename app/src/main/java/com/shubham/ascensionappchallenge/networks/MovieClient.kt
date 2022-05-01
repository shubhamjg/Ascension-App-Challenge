package com.shubham.ascensionappchallenge.networks

import com.shubham.ascensionappchallenge.common.Constants
import com.shubham.ascensionappchallenge.model.responses.movie.MovieResponse
import com.shubham.ascensionappchallenge.model.responses.search.SearchResponse
import com.shubham.ascensionappchallenge.model.responses.tv.TvShowResponse
import javax.inject.Inject

class MovieClient @Inject constructor(private var movieApi: MovieService ) {
    suspend fun getSearchAsync(queryText: String, page: Int): SearchResponse {
        return movieApi.getSearchAsync(Constants.API_KEY, queryText, page)
    }

    suspend fun getMovieDetailsAsync(movieId: Int): MovieResponse {
        return movieApi.getMovieDetailsAsync(movieId, Constants.API_KEY,Constants.IS_MOVIE)
    }

    suspend fun getTvShowDetailsAsync(tvId: Int): TvShowResponse {
        return movieApi.getTvShowDetailsAsync(tvId, Constants.API_KEY,Constants.IS_MOVIE)
    }
}
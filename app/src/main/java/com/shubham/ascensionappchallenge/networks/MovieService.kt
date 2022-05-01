package com.shubham.ascensionappchallenge.networks

import com.shubham.ascensionappchallenge.model.responses.movie.MovieResponse
import com.shubham.ascensionappchallenge.model.responses.search.SearchResponse
import com.shubham.ascensionappchallenge.model.responses.tv.TvShowResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("search/multi")
    suspend fun getSearchAsync(@Query("api_key") apiKey: String,
                               @Query("query") query: String,
                               @Query("page") page: Int): SearchResponse


    @GET("movie/{movieId}")
    suspend fun getMovieDetailsAsync(@Path("movieId") movieId: Int,
                                     @Query("api_key") apiKey: String,
                                     @Query("append_to_response") appendToResponse: String): MovieResponse


    @GET("tv/{tvId}")
    suspend fun getTvShowDetailsAsync(@Path("tvId") movieId: Int,
                                      @Query("api_key") apiKey: String,
                                      @Query("append_to_response") appendToResponse: String): TvShowResponse
}
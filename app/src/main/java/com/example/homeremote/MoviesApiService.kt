package com.example.homeremote

import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {
    @GET("movie/popular?api_key=${MOVIE_API_KEY}&language=en-US")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ): MovieResponse
}
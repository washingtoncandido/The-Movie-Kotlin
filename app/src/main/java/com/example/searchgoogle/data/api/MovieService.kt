package com.example.searchgoogle.data.api


import com.example.searchgoogle.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET


interface MovieService {
    @GET("movie/popular?api_key=8136c723df426fa6293e5902f12f63c0")
    fun getMoviePopulares(): Call<MovieResponse>

}
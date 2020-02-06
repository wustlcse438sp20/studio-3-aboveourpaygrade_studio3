package com.example.cse438.studio3.Network

import com.example.cse438.studio3.data.Brewery
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweryInterface {

    @GET("breweries")
    fun getBreweryByCity(@Query("by_city") city: String): Response<List<Brewery>>


    @GET("breweries/search")
    fun searchBreweries(@Query("query") query: String): Response<List<Brewery>>

}
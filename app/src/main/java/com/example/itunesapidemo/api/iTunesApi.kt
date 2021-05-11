package com.example.itunesapidemo.api

import com.example.itunesapidemo.models.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface iTunesApi {

    @GET("search")
    suspend fun getSongs(
        @Query("term")
        searchQuery: String,
        @Query("entity")
        searchType: String = "musicTrack"
    ):Response<SearchResponse>


}
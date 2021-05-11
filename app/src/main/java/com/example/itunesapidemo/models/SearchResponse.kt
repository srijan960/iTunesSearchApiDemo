package com.example.itunesapidemo.models

data class SearchResponse(
	val resultCount: Int? = null,
	val results: List<Song>
)

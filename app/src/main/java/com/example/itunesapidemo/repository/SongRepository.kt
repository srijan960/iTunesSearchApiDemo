package com.example.itunesapidemo.repository

import com.example.itunesapidemo.api.RetrofitInstance
import com.example.itunesapidemo.db.SongDatabase
import com.example.itunesapidemo.models.Song

class SongRepository(val db: SongDatabase) {

    suspend fun getSongs(searchQuery: String)=
            RetrofitInstance.api.getSongs(searchQuery)

    suspend fun upsert(song: Song) = db.getSongDao().upsert(song)

    fun getSavedNews() = db.getSongDao().getAllSongs()

    suspend fun deleteSong(song: Song) = db.getSongDao().deleteArticle(song)

}
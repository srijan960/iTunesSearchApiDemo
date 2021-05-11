package com.example.itunesapidemo.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.itunesapidemo.models.Song

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(song: Song): Long

    @Query("SELECT * FROM songs")
    fun getAllSongs() : LiveData<List<Song>>

    @Delete
    suspend fun deleteArticle(song: Song)

}
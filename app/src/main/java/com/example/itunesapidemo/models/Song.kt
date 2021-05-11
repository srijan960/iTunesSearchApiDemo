package com.example.itunesapidemo.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
	tableName = "songs"
)
data class Song(
	@PrimaryKey(autoGenerate = true)
	var id: Int? = null,
	val artworkUrl100: String? = null,
	val trackName: String? = null,
	val artistName: String? = null
): Serializable


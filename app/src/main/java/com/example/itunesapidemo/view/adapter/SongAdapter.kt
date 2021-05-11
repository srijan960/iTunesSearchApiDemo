package com.example.itunesapidemo.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.itunesapidemo.R
import com.example.itunesapidemo.models.Song
import com.example.itunesapidemo.viewModel.SongViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_song.view.*

class SongAdapter(private val songViewModel: SongViewModel?) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    private var songlist = emptyList<Song>()

    inner class SongViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_song,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return songlist.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val currentSong = songlist.get(position)
        holder.itemView.apply {
            if(!currentSong.artworkUrl100.isNullOrEmpty()){
                Glide.with(this).load(currentSong.artworkUrl100).into(ivTrack)
                tvArtistName.text = currentSong.artistName
                tvTrackName.text = currentSong.trackName
            }

            imFav.setOnClickListener {
                songViewModel?.saveSong(currentSong)
                Toast.makeText(context, "New unit added successfully", Toast.LENGTH_SHORT).show()
            }
        }


    }


    fun setData(newList : List<Song>){
        songlist = newList
        notifyDataSetChanged()
    }
}
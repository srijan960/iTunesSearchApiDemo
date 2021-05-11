package com.example.itunesapidemo.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.itunesapidemo.R
import com.example.itunesapidemo.db.SongDatabase
import com.example.itunesapidemo.models.Song
import com.example.itunesapidemo.repository.SongRepository
import com.example.itunesapidemo.viewModel.SongViewModel
import com.example.itunesapidemo.viewModel.base.SongViewModelProviderFactory
import kotlinx.android.synthetic.main.song_activity.*

class SongActivity : AppCompatActivity() {
    lateinit var viewModel: SongViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.song_activity)
        bottomNavigationView.setupWithNavController(songHostFragment.findNavController())
        val songRepository = SongRepository(SongDatabase(this))
        val viewModelProviderFactory = SongViewModelProviderFactory(songRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(SongViewModel::class.java)
    }




}
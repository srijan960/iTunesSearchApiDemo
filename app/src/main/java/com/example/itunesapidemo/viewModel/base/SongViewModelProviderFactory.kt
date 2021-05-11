package com.example.itunesapidemo.viewModel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itunesapidemo.repository.SongRepository
import com.example.itunesapidemo.viewModel.SongViewModel

class SongViewModelProviderFactory(val songRepository: SongRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SongViewModel(songRepository) as T
    }
}
package com.example.itunesapidemo.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itunesapidemo.models.SearchResponse
import com.example.itunesapidemo.models.Song
import com.example.itunesapidemo.repository.SongRepository
import com.example.itunesapidemo.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class SongViewModel(val songRepository: SongRepository): ViewModel() {

    val songs: MutableLiveData<Resource<SearchResponse>> = MutableLiveData()

    fun getSongs(searchQuery : String) = viewModelScope.launch {
        songs.postValue(Resource.Loading())
        val response = songRepository.getSongs(searchQuery)
        songs.postValue(handleGetSongResponse(response))
    }

    private fun handleGetSongResponse(response: Response<SearchResponse>): Resource<SearchResponse>{
        if(response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    fun saveSong(song: Song) = viewModelScope.launch {
        songRepository.upsert(song)
    }

    fun  getSaveSong() = songRepository.getSavedNews()

    fun deleteSong(song: Song) = viewModelScope.launch {
        songRepository.deleteSong(song)
    }

}
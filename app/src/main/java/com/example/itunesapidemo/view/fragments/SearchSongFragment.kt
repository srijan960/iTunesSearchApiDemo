package com.example.itunesapidemo.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.itunesapidemo.R
import com.example.itunesapidemo.util.Resource
import com.example.itunesapidemo.view.activity.SongActivity
import com.example.itunesapidemo.view.adapter.SongAdapter
import com.example.itunesapidemo.viewModel.SongViewModel
import kotlinx.android.synthetic.main.f_search_song.*

class SearchSongFragment:Fragment(R.layout.f_search_song) {


    lateinit var viewModel:SongViewModel
    lateinit var songAdapter: SongAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as SongActivity).viewModel
        setlistener()
        setObserver()
        setupRecyclerView()

    }

        private fun setlistener() {
        svSongs.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                svSongs.clearFocus()
                if (query != null) {
                    viewModel.getSongs(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               return false
            }

        })
    }

        private fun setupRecyclerView() {
        songAdapter = SongAdapter(viewModel)
        rvSongs.apply {
            adapter = songAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }
    }

    private fun setObserver() {
        viewModel.songs.observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Success ->{
                    it.data?.let {
                        songAdapter.setData(it.results)
                    }
                }
            }
        })
    }



}
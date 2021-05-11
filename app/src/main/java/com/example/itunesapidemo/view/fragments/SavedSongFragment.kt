package com.example.itunesapidemo.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.itunesapidemo.R
import com.example.itunesapidemo.util.Resource
import com.example.itunesapidemo.view.activity.SongActivity
import com.example.itunesapidemo.view.adapter.SongAdapter
import com.example.itunesapidemo.viewModel.SongViewModel
import kotlinx.android.synthetic.main.f_saved_song.*


class SavedSongFragment: Fragment(R.layout.f_saved_song) {

    lateinit var viewModel: SongViewModel
    lateinit var songAdapter: SongAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as SongActivity).viewModel
        setObserver()
        setupRecyclerView()

    }



    private fun setupRecyclerView() {
        songAdapter = SongAdapter(viewModel)
        rvSongs.apply {
            adapter = songAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }
    }

    private fun setObserver() {
        viewModel.getSaveSong().observe(viewLifecycleOwner, Observer {
            songAdapter.setData(it)
        })
    }



}
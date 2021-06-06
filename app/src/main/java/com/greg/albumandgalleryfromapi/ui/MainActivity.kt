package com.greg.albumandgalleryfromapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.greg.albumandgalleryfromapi.R
import com.greg.albumandgalleryfromapi.adapter.AlbumAdapter
import com.greg.albumandgalleryfromapi.api.RetrofitService
import com.greg.albumandgalleryfromapi.databinding.ActivityMainBinding
import com.greg.albumandgalleryfromapi.injection.ViewModelFactory
import com.greg.albumandgalleryfromapi.repositories.AlbumRepository
import com.greg.albumandgalleryfromapi.repositories.AuthorRepository
import com.greg.albumandgalleryfromapi.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var retrofitService: RetrofitService
    private lateinit var binding: ActivityMainBinding
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofitService = RetrofitService.getInstance()
        configureViewModel()
        configureAlbumRecyclerView()
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Configure main view model -----------------------------------
    //----------------------------------------------------------------------------------------------

    private fun configureViewModel() {
        mainViewModel = ViewModelProvider(this, ViewModelFactory(AlbumRepository(retrofitService),
                AuthorRepository(retrofitService))).get(MainViewModel::class.java)
        mainViewModel.getAllAlbums()
        mainViewModel.getAllAuthors()
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Configure album recyclerview --------------------------------
    //----------------------------------------------------------------------------------------------

    private fun configureAlbumRecyclerView() {
        albumAdapter = AlbumAdapter()
        binding.albumRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.albumRecyclerView.adapter = albumAdapter
        mainViewModel.albumList.observe(this, Observer {
            albumAdapter.setAlbumList(it)
        })
        mainViewModel.authorList.observe(this, Observer {
            albumAdapter.setAuthorList(it)
        })

        mainViewModel.errorMessage.observe(this, Observer {  })

        mainViewModel.getAllAlbums()
    }
}
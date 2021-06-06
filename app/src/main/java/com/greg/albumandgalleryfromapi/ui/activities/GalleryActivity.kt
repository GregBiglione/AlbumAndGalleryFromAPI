package com.greg.albumandgalleryfromapi.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.greg.albumandgalleryfromapi.R
import com.greg.albumandgalleryfromapi.adapter.GalleryAdapter
import com.greg.albumandgalleryfromapi.api.RetrofitService
import com.greg.albumandgalleryfromapi.databinding.ActivityGalleryBinding
import com.greg.albumandgalleryfromapi.injection.ViewModelFactory
import com.greg.albumandgalleryfromapi.repositories.AlbumRepository
import com.greg.albumandgalleryfromapi.repositories.AuthorRepository
import com.greg.albumandgalleryfromapi.repositories.GalleryRepository
import com.greg.albumandgalleryfromapi.viewmodel.MainViewModel

class GalleryActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var retrofitService: RetrofitService
    private lateinit var binding: ActivityGalleryBinding
    private lateinit var galleryAdapter: GalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureViewModel()
        configureGalleryRecyclerView()
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Configure main view model -----------------------------------
    //----------------------------------------------------------------------------------------------

    private fun configureViewModel() {
        mainViewModel = ViewModelProvider(this, ViewModelFactory(AlbumRepository(retrofitService),
            AuthorRepository(retrofitService),
            GalleryRepository(retrofitService)
        )).get(MainViewModel::class.java)
        mainViewModel.getAllGalleries()
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Configure gallery recyclerview ------------------------------
    //----------------------------------------------------------------------------------------------

    private fun configureGalleryRecyclerView() {
        galleryAdapter = GalleryAdapter()
        binding.galleryRecyclerView.layoutManager = GridLayoutManager(this, 4)
        binding.galleryRecyclerView.adapter = galleryAdapter
        mainViewModel.galleryList.observe(this, Observer{
            galleryAdapter.setGalleryList(it)
        })
    }
}
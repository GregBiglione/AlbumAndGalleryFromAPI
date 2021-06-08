package com.greg.albumandgalleryfromapi.ui.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.greg.albumandgalleryfromapi.R
import com.greg.albumandgalleryfromapi.adapter.GalleryAdapter
import com.greg.albumandgalleryfromapi.databinding.ActivityGalleryBinding
import com.greg.albumandgalleryfromapi.model.Photo

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding
    private lateinit var galleryAdapter: GalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        configureGalleryRecyclerView()
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Configure gallery recyclerview ------------------------------
    //----------------------------------------------------------------------------------------------

    private fun configureGalleryRecyclerView() {
        val photo: List<Photo> = intent.getParcelableArrayListExtra("photos")!!
        galleryAdapter = GalleryAdapter(photo)
        binding.galleryRecyclerView.layoutManager = GridLayoutManager(this, 4)
        binding.galleryRecyclerView.adapter = galleryAdapter
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Back button to Main activity --------------------------------
    //----------------------------------------------------------------------------------------------

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
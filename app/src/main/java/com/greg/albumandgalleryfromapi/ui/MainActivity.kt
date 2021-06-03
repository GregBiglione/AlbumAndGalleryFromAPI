package com.greg.albumandgalleryfromapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greg.albumandgalleryfromapi.R
import com.greg.albumandgalleryfromapi.adapter.AlbumAdapter
import com.greg.albumandgalleryfromapi.model.Album

class MainActivity : AppCompatActivity() {

    private lateinit var albumRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        albumRecyclerView = findViewById(R.id.album_recycler_view)
        configureAlbumRecyclerView()
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Configure album recyclerview --------------------------------
    //----------------------------------------------------------------------------------------------

    private fun configureAlbumRecyclerView() {
        val listOfAlbum = emptyList<Album>() // Temporary empty list to avoid a crash
        albumRecyclerView.adapter = AlbumAdapter(listOfAlbum)
        albumRecyclerView.layoutManager = LinearLayoutManager(this)
        albumRecyclerView.setHasFixedSize(true)
    }
}
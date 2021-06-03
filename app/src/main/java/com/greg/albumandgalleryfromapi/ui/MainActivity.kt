package com.greg.albumandgalleryfromapi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greg.albumandgalleryfromapi.R
import com.greg.albumandgalleryfromapi.adapter.AlbumAdapter
import com.greg.albumandgalleryfromapi.api.JsonPlaceHolderApi
import com.greg.albumandgalleryfromapi.constant.Constant.Companion.BASE_URL
import com.greg.albumandgalleryfromapi.model.Album
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var albumRecyclerView: RecyclerView
    //private lateinit var retrofit: Retrofit
    //private lateinit var jsonPlaceHolderApi: JsonPlaceHolderApi
    //private lateinit var albumList: Call<List<Album>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        albumRecyclerView = findViewById(R.id.album_recycler_view)
        configureAlbumRecyclerView()
        //initializeRetrofit()
        //initializeJsonPlaceHolderApi()
        //getAlbumList()
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

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Initialize retrofit -----------------------------------------
    //----------------------------------------------------------------------------------------------

    //private fun initializeRetrofit() {
    //    retrofit = Retrofit.Builder()
    //            .baseUrl(BASE_URL)
    //            .addConverterFactory(GsonConverterFactory.create())
    //            .build()
    //}

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Initialize JsonPlaceHolderApi -------------------------------
    //----------------------------------------------------------------------------------------------

    //private fun initializeJsonPlaceHolderApi() {
    //    jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
    //}

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Get album list from API -------------------------------------
    //----------------------------------------------------------------------------------------------

    //private fun getAlbumList() {
    //    albumList = jsonPlaceHolderApi.getAllAlbums()
    //}
}
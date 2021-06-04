package com.greg.albumandgalleryfromapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.greg.albumandgalleryfromapi.model.Album
import com.greg.albumandgalleryfromapi.repositories.AlbumRepository
import retrofit2.Call
import retrofit2.Response

class MainViewModel(private val albumRepository: AlbumRepository): ViewModel() {

    val albumList = MutableLiveData<List<Album>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllAlbums(){
        val response = albumRepository.getAllAlbums()
        response.enqueue(object : retrofit2.Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                albumList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}
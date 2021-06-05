package com.greg.albumandgalleryfromapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.greg.albumandgalleryfromapi.model.Album
import com.greg.albumandgalleryfromapi.model.Author
import com.greg.albumandgalleryfromapi.repositories.AlbumRepository
import com.greg.albumandgalleryfromapi.repositories.AuthorRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val albumRepository: AlbumRepository,
                    private val authorRepository: AuthorRepository): ViewModel() {

    val albumList = MutableLiveData<List<Album>>()
    val authorList = MutableLiveData<List<Author>>()
    val errorMessage = MutableLiveData<String>()

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Get all albums ----------------------------------------------
    //----------------------------------------------------------------------------------------------

    fun getAllAlbums(){
        val response = albumRepository.getAllAlbums()
        response.enqueue(object : Callback<List<Album>>{
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                albumList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Get all authors ---------------------------------------------
    //----------------------------------------------------------------------------------------------

    fun getAllAuthors(){
        val response = authorRepository.getAllAuthors()
        response.enqueue(object : Callback<List<Author>>{
            override fun onResponse(call: Call<List<Author>>, response: Response<List<Author>>) {
                authorList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Author>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}
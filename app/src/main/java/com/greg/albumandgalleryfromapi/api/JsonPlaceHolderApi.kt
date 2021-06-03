package com.greg.albumandgalleryfromapi.api

import com.greg.albumandgalleryfromapi.model.Album
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET


interface JsonPlaceHolderApi {

    //@GET("albums")
    //fun getAllAlbums(): Call<List<Album>>

    @GET("albums")
    fun getAllAlbums(): Call<ResponseBody>
}
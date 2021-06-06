package com.greg.albumandgalleryfromapi.api

import com.greg.albumandgalleryfromapi.constant.Constant.Companion.BASE_URL
import com.greg.albumandgalleryfromapi.model.Album
import com.greg.albumandgalleryfromapi.model.Author
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("albums")
    fun getAllAlbums(@Query("_sort") sort: String,
                     @Query("_order") order: String): Call<List<Album>>

    @GET("users")
    fun getAllAuthors(): Call<List<Author>>

    companion object{

        private var retrofitService: RetrofitService? = null
        private lateinit var retrofit: Retrofit

        //------------------------------------------------------------------------------------------
        //-------------------------------- Initialize retrofit -------------------------------------
        //------------------------------------------------------------------------------------------

        fun getInstance() : RetrofitService{
            if (retrofitService == null){
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                getApi()
            }
            return retrofitService!!
        }

        //------------------------------------------------------------------------------------------
        //-------------------------------- Initialize RetrofitService ------------------------------
        //------------------------------------------------------------------------------------------

        private fun getApi() {
            retrofitService = retrofit.create(RetrofitService::class.java)
        }
    }
}
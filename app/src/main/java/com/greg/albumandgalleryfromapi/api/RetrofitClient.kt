package com.greg.albumandgalleryfromapi.api

import com.greg.albumandgalleryfromapi.constant.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitClient {

    private lateinit var retrofit: Retrofit
    private var instance: RetrofitClient? = null
    private lateinit var jsonPlaceHolderApi: JsonPlaceHolderApi

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Initialize retrofit -----------------------------------------
    //----------------------------------------------------------------------------------------------

    private fun initializeRetrofit(){
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Get instance ------------------------------------------------
    //----------------------------------------------------------------------------------------------

    @Synchronized
    fun getInstance(): RetrofitClient?{
        if (instance == null){
            instance = RetrofitClient()
        }
        return instance
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Initialize JsonPlaceHolderApi -------------------------------
    //----------------------------------------------------------------------------------------------

    fun initializeJsonPlaceHolderApi() {
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java) //Check ig need return jsonPlaceHolderApi
    }
}
package com.greg.albumandgalleryfromapi.api

import com.greg.albumandgalleryfromapi.constant.Constant.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    private var retrofitService: RetrofitService? = null
    private lateinit var retrofit: Retrofit

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Initialize retrofit -----------------------------------------
    //----------------------------------------------------------------------------------------------

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

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Initialize JsonPlaceHolderApi -------------------------------
    //----------------------------------------------------------------------------------------------

    fun getApi() : JsonPlaceHolderApi{
        return retrofit.create(JsonPlaceHolderApi::class.java)
    }

    //var retrofitService: RetrofitService? = null
//
    //fun getInstance() : RetrofitService {
//
    //    if (retrofitService == null) {
    //        val retrofit = Retrofit.Builder()
    //            .baseUrl("https://howtodoandroid.com/")
    //            .addConverterFactory(GsonConverterFactory.create())
    //            .build()
    //        retrofitService = retrofit.create(RetrofitService::class.java)
    //    }
    //    return retrofitService!!
    //}
    //private lateinit var retrofit: Retrofit
    //private var instance: RetrofitClient? = null
    ////private lateinit var jsonPlaceHolderApi: JsonPlaceHolderApi
//
    ////----------------------------------------------------------------------------------------------
    ////-------------------------------- Initialize retrofit -----------------------------------------
    ////----------------------------------------------------------------------------------------------
//
    //private fun RetrofitClient(): RetrofitClient? { //1
    //    retrofit = Retrofit.Builder()
    //        .baseUrl(BASE_URL)
    //        .addConverterFactory(ScalarsConverterFactory.create())
    //        .addConverterFactory(GsonConverterFactory.create())
    //        .build()
    //    return null //2
    //}
//
//
    ////----------------------------------------------------------------------------------------------
    ////-------------------------------- Get instance ------------------------------------------------
    ////----------------------------------------------------------------------------------------------
//
    //@Synchronized
    //fun getInstance(): RetrofitClient?{
    //    if (instance == null){
    //        instance = RetrofitClient()
    //    }
    //    return instance
    //}
//
    ////----------------------------------------------------------------------------------------------
    ////-------------------------------- Initialize JsonPlaceHolderApi -------------------------------
    ////----------------------------------------------------------------------------------------------
//
    //fun getApi(): JsonPlaceHolderApi {
    //    return retrofit.create(JsonPlaceHolderApi::class.java)
    //}

}
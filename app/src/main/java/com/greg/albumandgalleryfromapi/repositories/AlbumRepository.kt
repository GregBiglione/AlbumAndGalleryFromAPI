package com.greg.albumandgalleryfromapi.repositories

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.greg.albumandgalleryfromapi.api.RetrofitService
import com.greg.albumandgalleryfromapi.model.Album
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


class AlbumRepository(private val retrofitService: RetrofitService) {

    fun getAllAlbums() = retrofitService.getInstance().getApi().getAllAlbums()

    //private lateinit var allAlbums: MutableLiveData<ArrayList<Album>>
    //private lateinit var albumList: ArrayList<Album>
    ////private lateinit var retrofitClient: RetrofitClient
//
    //fun getAlbumRepository(application: Application?) {
    //    allAlbums = MutableLiveData()
    //    albumList = ArrayList()
    //}
//
    //fun callAPI(): MutableLiveData<ArrayList<Album>> {
    //    val call : Call<ResponseBody> = RetrofitService().getInstance()!!.getApi().getAllAlbums()
    //    call.enqueue(object : Callback<ResponseBody?> {
    //        override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
    //            if (response.code() == 200) {
    //                try {
    //                    val dataArray = JSONArray(response.body()!!.string())
    //                    for (i in 0 until dataArray.length()) {
    //                        val dataObject = dataArray.getJSONObject(i)
    //                        val id = dataObject.getInt("id")
    //                        val userId = dataObject.getInt("userId")
    //                        val title = dataObject.getString("title")
    //                        val modelRecycler = Album(id, userId, title)
    //                        modelRecycler.id = id
    //                        modelRecycler.userId = userId
    //                        modelRecycler.title = title
    //                    }
    //                } catch (e: JSONException) {
    //                    e.printStackTrace()
    //                } catch (e: IOException) {
    //                    e.printStackTrace()
    //                }
    //            }
    //        }
//
    //        override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
    //            allAlbums.value = null
    //            println("t.getMessage() = " + t.message)
    //        }
    //    })
    //    return allAlbums
    //}
}
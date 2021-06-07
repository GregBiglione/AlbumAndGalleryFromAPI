package com.greg.albumandgalleryfromapi.repositories

import com.greg.albumandgalleryfromapi.api.RetrofitService

class PhotoRepository(private var retrofitService: RetrofitService) {

    fun getAllPhotos() = retrofitService.getAllPhotos()
}
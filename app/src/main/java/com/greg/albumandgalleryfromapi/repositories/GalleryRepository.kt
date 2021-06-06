package com.greg.albumandgalleryfromapi.repositories

import com.greg.albumandgalleryfromapi.api.RetrofitService

class GalleryRepository(private var retrofitService: RetrofitService) {

    fun getAllGalleries() = retrofitService.getAllGalleries()
}
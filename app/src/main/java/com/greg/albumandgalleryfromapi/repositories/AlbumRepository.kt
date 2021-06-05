package com.greg.albumandgalleryfromapi.repositories

import com.greg.albumandgalleryfromapi.api.RetrofitService

class AlbumRepository(private val retrofitService: RetrofitService) {

    fun getAllAlbums() = retrofitService.getAllAlbums("title", "asc")
}
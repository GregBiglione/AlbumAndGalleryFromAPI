package com.greg.albumandgalleryfromapi.repositories

import com.greg.albumandgalleryfromapi.api.RetrofitService

class AuthorRepository(private var retrofitService: RetrofitService) {

    fun getAllAuthors() = retrofitService.getAllAuthors()
}
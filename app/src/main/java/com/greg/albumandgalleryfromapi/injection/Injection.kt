package com.greg.albumandgalleryfromapi.injection

import android.content.Context
import com.greg.albumandgalleryfromapi.api.RetrofitService
import com.greg.albumandgalleryfromapi.repositories.AlbumRepository
import com.greg.albumandgalleryfromapi.repositories.AuthorRepository
import com.greg.albumandgalleryfromapi.repositories.PhotoRepository

class Injection {

    private val retrofitService: RetrofitService = RetrofitService.getInstance()

    private fun provideAlbumRepository(): AlbumRepository{
        return AlbumRepository(retrofitService)
    }

    private fun provideAuthorRepository(): AuthorRepository{
        return AuthorRepository(retrofitService)
    }

    private fun providePhotoRepository(): PhotoRepository{
        return PhotoRepository(retrofitService)
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory{
        val albumRepository: AlbumRepository = provideAlbumRepository()
        val authorRepository: AuthorRepository = provideAuthorRepository()
        val photoRepository: PhotoRepository = providePhotoRepository()
        return ViewModelFactory(albumRepository, authorRepository, photoRepository)
    }
}
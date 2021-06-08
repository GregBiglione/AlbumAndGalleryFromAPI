package com.greg.albumandgalleryfromapi.injection

import android.content.Context
import com.greg.albumandgalleryfromapi.api.RetrofitService
import com.greg.albumandgalleryfromapi.repositories.AlbumRepository
import com.greg.albumandgalleryfromapi.repositories.AuthorRepository
import com.greg.albumandgalleryfromapi.repositories.PhotoRepository

class Injection {

    private fun provideAlbumRepository(): AlbumRepository{
        val retrofitService: RetrofitService = RetrofitService.getInstance()
        return AlbumRepository(retrofitService)
    }

    private fun provideAuthorRepository(): AuthorRepository{
        val retrofitService: RetrofitService = RetrofitService.getInstance()
        return AuthorRepository(retrofitService)
    }

    private fun providePhotoRepository(): PhotoRepository{
        val retrofitService: RetrofitService = RetrofitService.getInstance()
        return PhotoRepository(retrofitService)
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory{
        val albumRepository: AlbumRepository = provideAlbumRepository()
        val authorRepository: AuthorRepository = provideAuthorRepository()
        val photoRepository: PhotoRepository = providePhotoRepository()
        return ViewModelFactory(albumRepository, authorRepository, photoRepository)
    }
}
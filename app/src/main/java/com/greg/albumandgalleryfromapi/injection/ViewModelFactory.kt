package com.greg.albumandgalleryfromapi.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.greg.albumandgalleryfromapi.repositories.AlbumRepository
import com.greg.albumandgalleryfromapi.repositories.AuthorRepository
import com.greg.albumandgalleryfromapi.repositories.GalleryRepository
import com.greg.albumandgalleryfromapi.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val albumRepository: AlbumRepository,
                       private val authorRepository: AuthorRepository,
                       private val galleryRepository: GalleryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(albumRepository, authorRepository, galleryRepository) as T
        }

        throw IllegalArgumentException("Unknown View Model class")
    }
}
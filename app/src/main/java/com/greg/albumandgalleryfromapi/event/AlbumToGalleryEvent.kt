package com.greg.albumandgalleryfromapi.event

import com.greg.albumandgalleryfromapi.model.Photo

data class AlbumToGalleryEvent(val photoList: ArrayList<Photo>/*val photoList: ArrayList<Photo>*/) {}
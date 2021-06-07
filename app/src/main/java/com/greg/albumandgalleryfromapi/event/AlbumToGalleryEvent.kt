package com.greg.albumandgalleryfromapi.event

import com.greg.albumandgalleryfromapi.model.Album

data class AlbumToGalleryEvent(val album: Album) {}
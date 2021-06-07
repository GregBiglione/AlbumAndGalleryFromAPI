package com.greg.albumandgalleryfromapi.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    var id: Int,
    var albumId: Int,
    var title: String,
    var url: String,
    var thumbnailUrl: String,
) : Parcelable
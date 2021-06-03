package com.greg.albumandgalleryfromapi.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Author(
    var id: Int,
    var name: String,
) : Parcelable
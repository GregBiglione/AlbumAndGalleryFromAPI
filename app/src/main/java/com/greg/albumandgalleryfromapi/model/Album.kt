package com.greg.albumandgalleryfromapi.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Album(
        var id: Int,
        var userId: Int,
        var title: String
) : Parcelable

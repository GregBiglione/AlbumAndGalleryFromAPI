package com.greg.albumandgalleryfromapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greg.albumandgalleryfromapi.R
import com.greg.albumandgalleryfromapi.databinding.GalleryItemBinding
import com.greg.albumandgalleryfromapi.model.Album
import com.greg.albumandgalleryfromapi.model.Photo
import com.squareup.picasso.Picasso

class GalleryAdapter(private var photoList: List<Photo>): RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val binding = GalleryItemBinding.inflate(itemView, parent, false)
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val currentGallery = photoList[position]//photos[position]

        Picasso.get()
            .load(currentGallery.thumbnailUrl)
            .into(holder.binding.galleryPhoto)
    }

    override fun getItemCount() =photoList.size //photos.size

    class GalleryViewHolder(val binding: GalleryItemBinding): RecyclerView.ViewHolder(binding.root){}
}
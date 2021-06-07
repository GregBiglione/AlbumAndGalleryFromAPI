package com.greg.albumandgalleryfromapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.greg.albumandgalleryfromapi.databinding.GalleryItemBinding
import com.greg.albumandgalleryfromapi.model.Album
import com.greg.albumandgalleryfromapi.model.Photo

class GalleryAdapter(private var album: Album/*private val gallery: Gallery*/): RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    private var galleryList = mutableListOf<Photo>()
    private var albumList = mutableListOf<Album>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val binding = GalleryItemBinding.inflate(itemView, parent, false)
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val currentGallery = galleryList[position]

        Glide.with(holder.binding.galleryPhoto)
            .load(getPhotos(currentGallery))
            .into(holder.binding.galleryPhoto)
    }

    override fun getItemCount() = galleryList.size

    class GalleryViewHolder(val binding: GalleryItemBinding): RecyclerView.ViewHolder(binding.root){}

    fun setGalleryList(photoList: List<Photo>){
        this.galleryList = photoList.toMutableList()
        notifyDataSetChanged()
    }

    fun setAlbumList(albumList: List<Album>){
        this.albumList = albumList.toMutableList()
        notifyDataSetChanged()
    }

    private fun getPhotos(currentPhoto: Photo) : String{
        for (album in albumList){
            if (currentPhoto.albumId == album.id){
                return currentPhoto.thumbnailUrl
            }
        }
        return ""
    }
}
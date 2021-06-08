package com.greg.albumandgalleryfromapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.greg.albumandgalleryfromapi.R
import com.greg.albumandgalleryfromapi.databinding.GalleryItemBinding
import com.greg.albumandgalleryfromapi.model.Album
import com.greg.albumandgalleryfromapi.model.Photo

class GalleryAdapter(private var photoList: List<Photo>/*private var photoList: MutableList<Photo> = mutableListOf()*/): RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    //private var photoList = mutableListOf<Photo>()
    //private var albumList = mutableListOf<Album>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val binding = GalleryItemBinding.inflate(itemView, parent, false)
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val currentGallery = photoList[position]//photos[position]

        Glide.with(holder.binding.galleryPhoto)
                .load(currentGallery.thumbnailUrl)
            //.load(getPhotos(currentGallery))
            .into(holder.binding.galleryPhoto)
    }

    override fun getItemCount() =photoList.size //photos.size

    class GalleryViewHolder(val binding: GalleryItemBinding): RecyclerView.ViewHolder(binding.root){}

    //fun setPhotoList(photoList: List<Photo>){
    //    this.photoList = photoList.toMutableList()
    //    notifyDataSetChanged()
    //}
//
    //fun setAlbumList(albumList: List<Album>){
    //    this.albumList = albumList.toMutableList()
    //    notifyDataSetChanged()
    //}

    //private fun getPhotos(currentPhoto: Photo) : String{
    //    for (album in albumList){
    //        if (currentPhoto.albumId == album.id){
    //            return currentPhoto.thumbnailUrl!!
    //        }
    //    }
    //    return ""
    //}
}
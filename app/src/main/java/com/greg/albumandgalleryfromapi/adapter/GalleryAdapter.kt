package com.greg.albumandgalleryfromapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.greg.albumandgalleryfromapi.databinding.GalleryItemBinding
import com.greg.albumandgalleryfromapi.model.Gallery

class GalleryAdapter: RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    private var galleryList = mutableListOf<Gallery>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val binding = GalleryItemBinding.inflate(itemView, parent, false)
        return GalleryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val currentGallery = galleryList[position]

        Glide.with(holder.binding.galleryPhoto)
            .load(currentGallery.thumbnailUrl)
            .into(holder.binding.galleryPhoto)
    }

    override fun getItemCount() = galleryList.size

    class GalleryViewHolder(val binding: GalleryItemBinding): RecyclerView.ViewHolder(binding.root){}

    fun setGalleryList(galleryList: List<Gallery>){
        this.galleryList = galleryList.toMutableList()
        notifyDataSetChanged()
    }
}
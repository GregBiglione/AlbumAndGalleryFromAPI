package com.greg.albumandgalleryfromapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greg.albumandgalleryfromapi.databinding.AlbumItemBinding
import com.greg.albumandgalleryfromapi.model.Album

class AlbumAdapter: RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    private var albumList = mutableListOf<Album>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val binding = AlbumItemBinding.inflate(itemView, parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val currentAlbum = albumList[position]
        holder.binding.albumName.text = currentAlbum.title
        holder.binding.authorName.text = currentAlbum.userId.toString()
    }

    override fun getItemCount() = albumList.size

    class AlbumViewHolder(val binding: AlbumItemBinding): RecyclerView.ViewHolder(binding.root){}

    fun setAlbumList(albumList: List<Album>){
        this.albumList = albumList.toMutableList()
        notifyDataSetChanged()
    }
}
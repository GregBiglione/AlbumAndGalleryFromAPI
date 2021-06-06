package com.greg.albumandgalleryfromapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greg.albumandgalleryfromapi.databinding.AlbumItemBinding
import com.greg.albumandgalleryfromapi.model.Album
import com.greg.albumandgalleryfromapi.model.Author

class AlbumAdapter: RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    private var albumList = mutableListOf<Album>()
    private var authorList = mutableListOf<Author>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val binding = AlbumItemBinding.inflate(itemView, parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val currentAlbum = albumList[position]

        holder.binding.albumName.text = currentAlbum.title
        holder.binding.authorName.text = getAuthorName(currentAlbum)
    }

    override fun getItemCount() = albumList.size

    class AlbumViewHolder(val binding: AlbumItemBinding): RecyclerView.ViewHolder(binding.root){}

    fun setAlbumList(albumList: List<Album>){
        this.albumList = albumList.toMutableList()
        notifyDataSetChanged()
    }

    fun setAuthorList(authorList: List<Author>){
        this.authorList = authorList.toMutableList()
        notifyDataSetChanged()
    }

    private fun getAuthorName(currentAlbum: Album) : String{
        for (author in authorList){
            if (currentAlbum.userId == author.id){
                return author.name
            }
        }
        return " "
    }
}
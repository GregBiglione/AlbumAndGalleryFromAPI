package com.greg.albumandgalleryfromapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.greg.albumandgalleryfromapi.R
import com.greg.albumandgalleryfromapi.model.Album
import kotlinx.android.synthetic.main.album_item.view.*

class AlbumAdapter(private val albumList: List<Album>): RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.album_item, parent, false)
        return AlbumViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val currentAlbum = albumList[position]
        holder.albumTitle.text = currentAlbum.title
        holder.albumAuthor.text = currentAlbum.userId.toString() // Check how to get name in Author
    }

    override fun getItemCount() = albumList.size

    class AlbumViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val albumLyt: LinearLayout = itemView.findViewById(R.id.album_main_linear_lyt)
        val albumTitle: TextView = itemView.findViewById(R.id.album_name)
        val albumAuthor: TextView = itemView.findViewById(R.id.author_name)
    }
}
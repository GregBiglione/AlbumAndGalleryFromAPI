package com.greg.albumandgalleryfromapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greg.albumandgalleryfromapi.databinding.AlbumItemBinding
import com.greg.albumandgalleryfromapi.event.AlbumToGalleryEvent
import com.greg.albumandgalleryfromapi.model.Album
import com.greg.albumandgalleryfromapi.model.Author
import com.greg.albumandgalleryfromapi.model.Photo
import org.greenrobot.eventbus.EventBus

class AlbumAdapter: RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    private var albumList = mutableListOf<Album>()
    private var authorList = mutableListOf<Author>()
    private var photoList = mutableListOf<Photo>()

    private var photoInAlbumList = generatePhotoList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val itemView = LayoutInflater.from(parent.context)
        val binding = AlbumItemBinding.inflate(itemView, parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val currentAlbum = albumList[position]

        holder.binding.albumName.text = currentAlbum.title
        holder.binding.authorName.text = getAuthorName(currentAlbum)

        holder.binding.albumCardView.setOnClickListener {
            EventBus.getDefault().post(AlbumToGalleryEvent(getPhoto(currentAlbum)))
            //EventBus.getDefault().post(getGallery(currentAlbum))
        }
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

    fun setPhotoList(photoList: List<Photo>){
        this.photoList = photoList.toMutableList()
        notifyDataSetChanged()
    }

    fun getPhoto(currentAlbum: Album) : ArrayList<Photo>{
        photoInAlbumList.clear()
        for (photo in photoList){
            if(currentAlbum.id == photo.albumId){
                photoInAlbumList.add(photo)
            }
        }
        return photoInAlbumList
    }

    private fun generatePhotoList(): ArrayList<Photo>{
        return ArrayList()
    }
    //private fun getGallery(currentAlbum: Album) : Photo?{
    //    for(photo in photoList){
    //        if (currentAlbum.id == photo.albumId){
    //            return photo
    //        }
    //    }
    //    return null
    //}
}
package com.greg.albumandgalleryfromapi.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.greg.albumandgalleryfromapi.R
import com.greg.albumandgalleryfromapi.adapter.AlbumAdapter
import com.greg.albumandgalleryfromapi.api.RetrofitService
import com.greg.albumandgalleryfromapi.databinding.ActivityMainBinding
import com.greg.albumandgalleryfromapi.event.AlbumToGalleryEvent
import com.greg.albumandgalleryfromapi.injection.Injection
import com.greg.albumandgalleryfromapi.injection.ViewModelFactory
import com.greg.albumandgalleryfromapi.viewmodel.MainViewModel
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var retrofitService: RetrofitService
    private lateinit var binding: ActivityMainBinding
    private lateinit var albumAdapter: AlbumAdapter
    private lateinit var injection: Injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofitService = RetrofitService.getInstance()
        injection = Injection()
        configureViewModel()
        configureAlbumRecyclerView()
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Configure main view model -----------------------------------
    //----------------------------------------------------------------------------------------------

    private fun configureViewModel() {
        val viewModelFactory: ViewModelFactory = injection.provideViewModelFactory(this)
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        mainViewModel.getAllAlbums()
        mainViewModel.getAllAuthors()
        mainViewModel.getAllPhotos()
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Configure album recyclerview --------------------------------
    //----------------------------------------------------------------------------------------------

    private fun configureAlbumRecyclerView() {
        albumAdapter = AlbumAdapter()
        binding.albumRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.albumRecyclerView.adapter = albumAdapter
        mainViewModel.albumList.observe(this, Observer { album ->
            albumAdapter.setAlbumList(album)
        })
        mainViewModel.authorList.observe(this, Observer { author ->
            albumAdapter.setAuthorList(author)
        })
        mainViewModel.photoList.observe(this, Observer { photo ->
            albumAdapter.setPhotoList(photo)
        })

        mainViewModel.errorMessage.observe(this, Observer {  })

        mainViewModel.getAllAlbums()
        //mainViewModel.getAllPhotos()
    }

    //----------------------------------------------------------------------------------------------
    //-------------------------------- Click on album item -----------------------------------------
    //----------------------------------------------------------------------------------------------

    @Subscribe
    fun onClickedAlbum(event: AlbumToGalleryEvent){
        val intent = Intent(this, GalleryActivity::class.java)
        intent.putExtra("photos", event.photoList)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}
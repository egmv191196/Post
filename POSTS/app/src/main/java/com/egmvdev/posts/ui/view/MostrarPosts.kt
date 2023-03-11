package com.egmvdev.posts.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.egmvdev.posts.databinding.ActivityMostrarPostsBinding
import com.egmvdev.posts.data.model.postResponse
import com.egmvdev.posts.ui.viewmodel.mostrarPostsViewModel

class MostrarPosts : AppCompatActivity() {
    private lateinit var bind:ActivityMostrarPostsBinding
    private val listaPost = mutableListOf<postResponse>()
    private  lateinit var postAdaptador: postAdapter
    private val mostrarPostVM: mostrarPostsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMostrarPostsBinding.inflate(layoutInflater)
        setContentView(bind.root)
        iniciarRecyclerView()
        mostrarPostVM.onCreate()
        mostrarPostVM.listPostResponse.observe(this, androidx.lifecycle.Observer {
            //Log.i("Respuesta", it.toString())
            listaPost.clear()
            for (i in it!!){
                listaPost.add(i)
            }
            postAdaptador.notifyDataSetChanged()
        })
    }
    fun iniciarRecyclerView(){
        postAdaptador= postAdapter(listaPost)
        bind.rvPosts.layoutManager = LinearLayoutManager(this)
        bind.rvPosts.adapter = postAdaptador
    }
}
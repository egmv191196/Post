package com.egmvdev.posts.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.egmvdev.posts.databinding.ActivityMostrarPostBinding
import com.egmvdev.posts.data.model.postResponse
import com.egmvdev.posts.ui.viewmodel.mostrarPostViewModel

class MostrarPost : AppCompatActivity() {
    private lateinit var bind:ActivityMostrarPostBinding
    private val listaPost = mutableListOf<postResponse>()
    private  lateinit var postAdaptador: postAdapter
    private val mostrarPostVM: mostrarPostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMostrarPostBinding.inflate(layoutInflater)
        setContentView(bind.root)
        iniciarRecyclerView()
        bind.btnConsulta.setOnClickListener {
            if(bind.etID.text.isNotEmpty()){
                mostrarPostVM.onCreate(bind.etID.text.toString())
                Toast.makeText(this,bind.etID.text.toString(),Toast.LENGTH_LONG).show()
            }
        }
        mostrarPostVM.listPostResponse.observe(this, androidx.lifecycle.Observer {
            Log.i("Respuesta", it.toString())
            listaPost.clear()
            listaPost.add(it)
            postAdaptador.notifyDataSetChanged()
        })
    }
    fun iniciarRecyclerView(){
        postAdaptador= postAdapter(listaPost)
        bind.rvPost.layoutManager = LinearLayoutManager(this)
        bind.rvPost.adapter = postAdaptador
    }

}
package com.egmvdev.posts.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.egmvdev.posts.databinding.ActivityAgregarPostBinding
import com.egmvdev.posts.data.model.postRequest
import com.egmvdev.posts.ui.viewmodel.agregarPostViewModel

class AgregarPost : AppCompatActivity() {
    private lateinit var bind:ActivityAgregarPostBinding
    private val addPostVM: agregarPostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityAgregarPostBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btnPost.setOnClickListener {
            if (bind.etUserID.text.isNotEmpty() && bind.etTitle.text.isNotEmpty() && bind.etBody.text.isNotEmpty()){
                addPostVM.onCreate(postRequest(bind.etUserID.text.toString(),"", bind.etTitle.text.toString(), bind.etBody.text.toString()))
            }
        }
        addPostVM.PostResponse.observe(this, Observer {
            bind.resultadoRequest.setText("Title:  ${it.title}  ID: ${it.id} UserID: ${it.userId} Body: ${it.body}")
            Log.i("Agregar Post", it.toString())
        })
    }
}
package com.egmvdev.posts.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.egmvdev.posts.databinding.ActivityDeletePostBinding
import com.egmvdev.posts.ui.viewmodel.deletePostViewModel

class DeletePost : AppCompatActivity() {
    private lateinit var bind:ActivityDeletePostBinding
    private val deletePostVM: deletePostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityDeletePostBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btnDelete.setOnClickListener {
            if (bind.etID.text.isNotEmpty()){
                deletePostVM.onCreate(bind.etID.text.toString())
            }
        }
        deletePostVM.PostResponse.observe(this, Observer {
            bind.resultadoRequest.setText("$it")
        })
    }
}
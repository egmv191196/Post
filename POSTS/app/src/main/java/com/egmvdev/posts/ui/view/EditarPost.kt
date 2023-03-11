package com.egmvdev.posts.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.egmvdev.posts.databinding.ActivityEditarPostBinding
import com.egmvdev.posts.data.model.postRequest
import com.egmvdev.posts.ui.viewmodel.editarPostViewModel

class EditarPost : AppCompatActivity() {
    private lateinit var bind:ActivityEditarPostBinding
    private val editPostVM: editarPostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityEditarPostBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btnPut.setOnClickListener {
            if (bind.etUserID.text.isNotEmpty() && bind.etTitle.text.isNotEmpty() && bind.etBody.text.isNotEmpty()){
                editPostVM.onCreate(bind.etID.text.toString(),
                    postRequest(bind.etUserID.text.toString(),bind.etID.text.toString(), bind.etTitle.text.toString(), bind.etBody.text.toString())
                )
            }
        }
        editPostVM.PostResponse.observe(this, Observer {
            bind.resultadoRequest.setText("Title:  ${it.title}  ID: ${it.id} UserID: ${it.userId} Body: ${it.body}")
        })
    }
}
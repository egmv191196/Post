package com.egmvdev.posts.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egmvdev.posts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btnListarPosts.setOnClickListener {
            var intent: Intent = Intent(this, MostrarPosts::class.java)
            startActivity(intent)
        }
        bind.btnListarPost.setOnClickListener {
            var intent: Intent = Intent(this, MostrarPost::class.java)
            startActivity(intent)
        }
        bind.btnAgregarPost.setOnClickListener {
            var intent: Intent = Intent(this, AgregarPost::class.java)
            startActivity(intent)
        }
        bind.btnEditarPost.setOnClickListener {
            var intent: Intent = Intent(this, EditarPost::class.java)
            startActivity(intent)
        }
        bind.btnBorrarPost.setOnClickListener {
            var intent: Intent = Intent(this, DeletePost::class.java)
            startActivity(intent)
        }
    }
}
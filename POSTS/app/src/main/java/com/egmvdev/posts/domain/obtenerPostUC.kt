package com.egmvdev.posts.domain

import com.egmvdev.posts.data.PostRepository

class obtenerPostUC {
    private val repository = PostRepository()
    suspend operator fun invoke(id:String) = repository.obtenerPost(id)
}
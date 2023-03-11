package com.egmvdev.posts.domain

import com.egmvdev.posts.data.PostRepository

class obtenerPostsUC {
    private val repository = PostRepository()
    suspend operator fun invoke() = repository.obtenerPosts()
}
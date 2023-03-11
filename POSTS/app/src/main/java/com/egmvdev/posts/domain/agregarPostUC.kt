package com.egmvdev.posts.domain

import com.egmvdev.posts.data.PostRepository
import com.egmvdev.posts.data.model.postRequest

class agregarPostUC {
    private val repository = PostRepository()
    suspend operator fun invoke(post:postRequest) = repository.agregarPost(post)
}
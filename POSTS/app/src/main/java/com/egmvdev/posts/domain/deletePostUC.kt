package com.egmvdev.posts.domain

import com.egmvdev.posts.data.PostRepository
import com.egmvdev.posts.data.model.postRequest

class deletePostUC {
    private val repository = PostRepository()
    suspend operator fun invoke(id:String) = repository.deletePost(id)
}
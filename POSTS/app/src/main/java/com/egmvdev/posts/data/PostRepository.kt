package com.egmvdev.posts.data

import com.egmvdev.posts.core.RetrofitHelper
import com.egmvdev.posts.data.model.postRequest
import com.egmvdev.posts.data.model.postResponse
import com.egmvdev.posts.data.network.APIServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun obtenerPosts(): List<postResponse> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(APIServices::class.java).obtenerPosts("posts")
            response.body() ?: emptyList()
        }
    }
    suspend fun obtenerPost(id:String): postResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(APIServices::class.java).obtenerPost(id)
            response.body()!!
        }
    }
    suspend fun agregarPost(post : postRequest): postResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(APIServices::class.java).agregarPost(post)
            response.body()!!
        }
    }
    suspend fun editarPost(id: String, post : postRequest): postResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(APIServices::class.java).editarPost(id,post)
            response.body()!!
        }
    }
    suspend fun deletePost(id: String): postResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(APIServices::class.java).borrarPost(id)
            response.body()!!
        }
    }


}
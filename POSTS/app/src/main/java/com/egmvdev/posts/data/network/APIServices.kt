package com.egmvdev.posts.data.network

import com.egmvdev.posts.data.model.postRequest
import com.egmvdev.posts.data.model.postResponse
import retrofit2.Response
import retrofit2.http.*

interface APIServices {
    //Metodos GET
    @GET
    suspend fun obtenerPosts(@Url url: String): Response<List<postResponse>>//List porque es un arreglo de postResponse
    @GET("posts/{id}")
    suspend fun obtenerPost(@Path("id") id:String): Response<postResponse>//Solo recupera un Post
    //Metodo POST
    @POST("posts")
    suspend fun agregarPost(@Body postRequest: postRequest): Response<postResponse>//el request es lo que manda, necesito una clase de ese tipo
    //Metodo PUT
    @PUT("posts/{id}")
    suspend fun editarPost(@Path("id") id:String, @Body postRequest: postRequest): Response<postResponse>
    //Metodo Delete
    @DELETE("posts/{id}")
    suspend fun borrarPost(@Path("id") id: String): Response<postResponse>
}
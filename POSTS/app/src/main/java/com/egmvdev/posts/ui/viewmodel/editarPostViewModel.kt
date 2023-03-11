package com.egmvdev.posts.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egmvdev.posts.core.RetrofitHelper
import com.egmvdev.posts.model.APIInterceptor
import com.egmvdev.posts.data.network.APIServices
import com.egmvdev.posts.data.model.postRequest
import com.egmvdev.posts.data.model.postResponse
import com.egmvdev.posts.domain.agregarPostUC
import com.egmvdev.posts.domain.editarPostUC
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class editarPostViewModel:ViewModel() {
    val PostResponse = MutableLiveData<postResponse>()
    var editarPost = editarPostUC()
    /*private val retrofit = RetrofitHelper.getRetrofit()
    fun editarPost(id:String,post: postRequest){
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = retrofit.create(APIServices::class.java).editarPost(id,post)
            val listPosts = llamada.body()
            if(llamada.isSuccessful){
                PostResponse.postValue(listPosts!!)
            }else{
                return@launch
            }
        }
    }*/
    fun onCreate(id:String, post: postRequest){
        viewModelScope.launch {
            PostResponse.postValue(editarPost(id,post)!!)
        }
    }
}
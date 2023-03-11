package com.egmvdev.posts.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egmvdev.posts.core.RetrofitHelper
import com.egmvdev.posts.data.model.postRequest
import com.egmvdev.posts.model.APIInterceptor
import com.egmvdev.posts.data.network.APIServices
import com.egmvdev.posts.data.model.postResponse
import com.egmvdev.posts.domain.deletePostUC
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class deletePostViewModel: ViewModel() {
    val PostResponse = MutableLiveData<postResponse>()
    var deletePost = deletePostUC()
    /*private val retrofit = RetrofitHelper.getRetrofit()
    fun deletePost(id: String){
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = retrofit.create(APIServices::class.java).borrarPost(id)
            val listPosts = llamada.body()
            if(llamada.isSuccessful){
                PostResponse.postValue(listPosts!!)
            }else{
                return@launch
            }
        }
    }*/
    fun onCreate(id:String){
        viewModelScope.launch {
            PostResponse.postValue(deletePost(id)!!)
        }
    }

}
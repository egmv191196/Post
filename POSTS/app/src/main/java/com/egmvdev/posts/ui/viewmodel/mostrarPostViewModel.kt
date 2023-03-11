package com.egmvdev.posts.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egmvdev.posts.core.RetrofitHelper
import com.egmvdev.posts.model.APIInterceptor
import com.egmvdev.posts.data.network.APIServices
import com.egmvdev.posts.data.model.postResponse
import com.egmvdev.posts.domain.obtenerPostUC
import com.egmvdev.posts.domain.obtenerPostsUC
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class mostrarPostViewModel:ViewModel() {
    val listPostResponse = MutableLiveData<postResponse>()
    var obtenerPosts = obtenerPostUC()
    /*private val retrofit = RetrofitHelper.getRetrofit()
    fun obtenerPost(id:String){
        CoroutineScope(Dispatchers.IO).launch {
            val llamada = retrofit.create(APIServices::class.java).obtenerPost(id)
            Log.i("Prubea",llamada.toString())
            val listPosts = llamada.body()
            if(llamada.isSuccessful){
                listPostResponse.postValue(listPosts!!)
            }else{
                return@launch
            }
        }
    }*/
    fun onCreate(id:String){
        viewModelScope.launch {
            listPostResponse.postValue(obtenerPosts(id)!!)
        }
    }
}
package com.egmvdev.posts.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.posts.R
import com.egmvdev.posts.data.model.postResponse

class postAdapter (val post: List<postResponse>): RecyclerView.Adapter<postViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        return  postViewHolder(inflador.inflate(R.layout.itempost,parent,false))
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
        holder.bind(post[position])
    }
    override fun getItemCount(): Int = post.size
}
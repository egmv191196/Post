package com.egmvdev.posts.ui.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.egmvdev.posts.databinding.ItempostBinding
import com.egmvdev.posts.data.model.postResponse

class postViewHolder (vista: View): RecyclerView.ViewHolder(vista) {
    private val bind =ItempostBinding.bind(vista)
    fun bind(post: postResponse){
        bind.tvTitle.text = post.title
        bind.tvCuerpo.text = post.body
    }
}
package com.kromer.presentation.features.main.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kromer.domain.features.posts.models.Post
import com.kromer.presentation.databinding.ItemPostBinding

class PostsAdapter : ListAdapter<Post, PostViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(
                oldItem: Post,
                newItem: Post
            ): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(
                oldItem: Post,
                newItem: Post
            ): Boolean =
                oldItem.photoPath == newItem.photoPath
        }
    }
}
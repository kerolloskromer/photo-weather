package com.kromer.presentation.features.main.posts

import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kromer.domain.features.posts.models.Post
import com.kromer.presentation.databinding.ItemPostBinding
import java.io.File

class PostViewHolder(
    private val binding: ItemPostBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Post) {
        binding.ivImage.load(item.photoPath.toUri())
    }
}
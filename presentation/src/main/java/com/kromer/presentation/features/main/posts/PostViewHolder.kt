package com.kromer.presentation.features.main.posts

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kromer.domain.features.posts.models.Post
import com.kromer.presentation.databinding.ItemPostBinding
import com.kromer.presentation.extensions.getUriForFilePath

class PostViewHolder(
    private val binding: ItemPostBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Post, onItemClick: (Post) -> Unit, onShareClick: (Post) -> Unit) {
        binding.ivImage.load(item.photoPath.getUriForFilePath(binding.ivImage.context))
        binding.root.setOnClickListener {
            onItemClick(item)
        }
        binding.ivShare.setOnClickListener {
            onShareClick(item)
        }
    }
}
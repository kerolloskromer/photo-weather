package com.kromer.presentation.features.main.posts

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.kromer.domain.features.posts.models.Post
import com.kromer.domain.utils.Status
import com.kromer.presentation.R
import com.kromer.presentation.base.BaseFragment
import com.kromer.presentation.databinding.FragmentPostsBinding
import com.kromer.presentation.extensions.show
import com.kromer.presentation.utils.MarginItemDecoration
import com.kromer.presentation.utils.ShareUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PostsFragment : BaseFragment<FragmentPostsBinding>() {

    private val viewModel: PostsViewModel by viewModels()
    private val adapter = PostsAdapter(::onItemClick, ::onShareClick)

    override fun getVBInflater(): (LayoutInflater) -> FragmentPostsBinding =
        FragmentPostsBinding::inflate

    override fun setupViews() {
        setupRecyclerView()
        getPosts()
        binding.btnCreatePost.setOnClickListener {
            val action = PostsFragmentDirections.actionNavigationToCreatePost()
            findNavController().navigate(action)
        }
    }

    private fun setupRecyclerView() {
        binding.rvPosts.addItemDecoration(
            MarginItemDecoration(
                0,
                resources.getDimensionPixelSize(R.dimen.list_item_margin),
                0,
                resources.getDimensionPixelSize(R.dimen.list_item_margin)
            )
        )
        binding.rvPosts.adapter = adapter
    }

    private fun getPosts() {
        viewModel.getPosts().observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {
                    showLoading(true)
                }
                Status.SUCCESS -> {
                    showLoading(false)
                    lifecycle.coroutineScope.launch {
                        it.data?.collect { list ->
                            adapter.submitList(list)
                        }
                    }
                }
                Status.ERROR -> {
                    showLoading(false)
                }
            }
        }
    }

    private fun showLoading(show: Boolean) {
        binding.progressBar.show(show)
        binding.rvPosts.show(show.not())
    }

    private fun onItemClick(item: Post) {
        val action = PostsFragmentDirections.actionNavigationToPostDetails(item.id)
        findNavController().navigate(action)
    }

    private fun onShareClick(item: Post) {
        ShareUtils.share(requireContext(), item.photoPath)
    }
}
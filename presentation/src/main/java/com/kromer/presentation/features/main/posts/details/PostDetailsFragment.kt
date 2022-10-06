package com.kromer.presentation.features.main.posts.details

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import coil.load
import com.kromer.domain.features.posts.models.Post
import com.kromer.domain.utils.Status
import com.kromer.presentation.base.BaseDialogFragment
import com.kromer.presentation.databinding.FragmentPostDetailsBinding
import com.kromer.presentation.extensions.getUriForFilePath
import com.kromer.presentation.extensions.show
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailsFragment : BaseDialogFragment<FragmentPostDetailsBinding>() {

    private val viewModel: PostDetailsViewModel by viewModels()
    private var postId: Long = 0

    override fun getVBInflater(): (LayoutInflater) -> FragmentPostDetailsBinding =
        FragmentPostDetailsBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getExtras()
    }

    override fun setupViews() {
        getPost(postId)
    }

    private fun getExtras() {
        val args = PostDetailsFragmentArgs.fromBundle(requireArguments())
        postId = args.postId
    }

    private fun getPost(id: Long?) {
        viewModel.getPost(id).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.LOADING -> {
                    showLoading(true)
                }
                Status.SUCCESS -> {
                    showLoading(false)
                    it.data?.let { post ->
                        setData(post)
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
        binding.ivImage.show(show.not())
    }

    private fun setData(item: Post) {
        binding.ivImage.load(item.originalPhotoPath.getUriForFilePath(binding.ivImage.context))
    }
}
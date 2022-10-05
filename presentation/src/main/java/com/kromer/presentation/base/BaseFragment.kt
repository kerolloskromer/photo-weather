package com.kromer.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.kromer.domain.utils.Failure
import com.kromer.presentation.R

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: VB? = null
    open val binding get() = _binding!!

    private var isViewCreated: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (_binding == null) {
            _binding = getVBInflater().invoke(layoutInflater)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isViewCreated.not()) {
            setupViews()
            isViewCreated = true
        }
    }

    protected abstract fun getVBInflater(): (LayoutInflater) -> VB

    protected abstract fun setupViews()

    fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    fun showMessage(message: String?) {
        message?.let {
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    fun handleFailure(failure: Failure?) {
        showError(failure?.message ?: getString(R.string.error_unknown))
    }
}
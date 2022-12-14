package com.kromer.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    open lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getVBInflater().invoke(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    protected abstract fun getVBInflater(): (LayoutInflater) -> VB

    protected abstract fun setupViews()
}
package com.devdhruv.iTunesApi.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.devdhruv.iTunesApi.R
import com.devdhruv.iTunesApi.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private val viewModel: SearchFragmentViewModel by lazy {
        ViewModelProvider(this).get(SearchFragmentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSearchBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_search, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel


        return binding.root
    }

}
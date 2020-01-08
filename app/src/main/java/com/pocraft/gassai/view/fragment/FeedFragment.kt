package com.pocraft.gassai.view.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe

import com.pocraft.gassai.R
import com.pocraft.gassai.databinding.FeedFragmentBinding
import com.pocraft.gassai.model.dummyPosts
import com.pocraft.gassai.util.lazyViewModel
import com.pocraft.gassai.view.adapter.PostAdapter
import com.pocraft.gassai.viewmodel.FeedViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }
    private lateinit var binding: FeedFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazyViewModel<FeedViewModel> { viewModelFactory }

    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.feed_fragment,
            container,
            false
        )
        binding.feedViewModel = viewModel

        binding.lifecycleOwner = this

        adapter = PostAdapter()
        binding.postRecyclerview.adapter = adapter

        adapter.submitList(listOf())


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        viewModel.posts.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

}

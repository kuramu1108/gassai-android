package com.pocraft.gassai.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pocraft.gassai.model.Post
import com.pocraft.gassai.model.dummyPosts
import javax.inject.Inject

class FeedViewModel @Inject constructor(): ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>>
        get() = liveData { emit(dummyPosts.toList()) }
}

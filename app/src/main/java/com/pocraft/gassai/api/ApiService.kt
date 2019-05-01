package com.pocraft.gassai.api

import com.pocraft.gassai.model.Repository
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/users/{user}/repos")
    fun getRepository(@Path("user") user:String): Deferred<List<Repository>>
}
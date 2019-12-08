package com.pocraft.gassai.api

import com.pocraft.gassai.model.Repository
import com.pocraft.gassai.model.Team
import com.pocraft.gassai.model.db.TableVersion
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
//    @GET("/users/{user}/repos")
//    fun getRepository(@Path("user") user:String): Deferred<List<Repository>>

    @GET("/api/teams/all")
    fun getAllTeams(): Deferred<Response<List<Team>>>

    @GET("/api/teams/version")
    fun getTeamVersion(): Deferred<TableVersion>
}
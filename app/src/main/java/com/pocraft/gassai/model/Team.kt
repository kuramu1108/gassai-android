package com.pocraft.gassai.model

data class Team (
    val id: Long,
    val name: String,
    val from: String,
    var participation: Int,
    var description: String
)
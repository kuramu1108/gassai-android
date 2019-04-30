package com.pocraft.gassai.model

data class Venue (
    val id: Long,
    var name: String,
    var timeTables: List<TimeTable>
)
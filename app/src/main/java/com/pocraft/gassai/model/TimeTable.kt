package com.pocraft.gassai.model

import java.util.Date

data class TimeTable(
    val id:Long,
    var team: Team,
    var Venue: Venue,
    val time: Date,
    var description: String
)

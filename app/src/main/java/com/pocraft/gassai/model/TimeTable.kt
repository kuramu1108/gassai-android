package com.pocraft.gassai.model

import java.time.LocalDate
import java.time.LocalTime

data class TimeTable(
    val id:Long,
    var team: Team?,
    var Venue: Venue?,
    val date: LocalDate,
    val time: LocalTime,
    var description: String
)

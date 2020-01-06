package com.pocraft.gassai.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class Team (
    @PrimaryKey
    val id: Long,
    val name: String,
    val from: String,
    var participation: Int,
    var description: String,
//    @ColumnInfo
    var isFavorite: Boolean = false
) {
    fun isIdentical(t: Team) = id == t.id && name == t.name && participation == t.participation
}
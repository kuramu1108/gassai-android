package com.pocraft.gassai.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "teams")
data class Team (
    @PrimaryKey
    val id: Long,
    val name: String,
    val from: String,
    var participation: Int,
    var description: String,
//    @ColumnInfo
    var isFavorite: Boolean
)
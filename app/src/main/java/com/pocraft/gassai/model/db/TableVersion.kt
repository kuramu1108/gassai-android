package com.pocraft.gassai.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_version")
class TableVersion (
    @PrimaryKey
    val id: Long,
    val tableName: String,
    val version: Long
)
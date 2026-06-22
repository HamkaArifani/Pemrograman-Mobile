package com.example.listcompose.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class FilmRoomEntity (
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int
)
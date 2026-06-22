package com.example.listcompose.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "reviews",
    foreignKeys = [
        ForeignKey(
            entity = FilmRoomEntity::class,
            parentColumns = ["id"],
            childColumns = ["film_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ReviewEntity (
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "review_id") val reviewId: Int = 0,
    @ColumnInfo(name = "film_id") val filmId: Int,
    @ColumnInfo(name = "review") val review: String
)
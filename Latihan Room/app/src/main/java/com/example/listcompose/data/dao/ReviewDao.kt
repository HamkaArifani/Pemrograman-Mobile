package com.example.listcompose.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.listcompose.data.entity.FilmRoomEntity
import com.example.listcompose.data.entity.ReviewEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFilmId(film: FilmRoomEntity)

    @Insert
    suspend fun insertReview(review: ReviewEntity)

    @Query("SELECT * FROM reviews WHERE film_id = :filmId ORDER BY review_id DESC")
    fun getReviewsForFilms(filmId: Int): Flow<List<ReviewEntity>>
}
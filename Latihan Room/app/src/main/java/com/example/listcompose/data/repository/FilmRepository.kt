package com.example.listcompose.data.repository

import com.example.listcompose.data.DataSource
import com.example.listcompose.data.dao.ReviewDao
import com.example.listcompose.data.entity.FilmRoomEntity
import com.example.listcompose.data.entity.ReviewEntity
import com.example.listcompose.model.Film
import kotlinx.coroutines.flow.Flow

class FilmRepository(private val reviewDao: ReviewDao) {
    private val dataSource = DataSource()

    fun getFilms(): List<Film> = dataSource.listFilm()
    fun getFilmById(id: Int): Film? = dataSource.listFilm().find { it.id == id }

    fun getReviewsForFilm(filmId: Int): Flow<List<ReviewEntity>> = reviewDao.getReviewsForFilms(filmId)
    suspend fun insertReview(review: ReviewEntity) = reviewDao.insertReview(review)
    suspend fun insertFilmId(film: FilmRoomEntity) = reviewDao.insertFilmId(film)
}
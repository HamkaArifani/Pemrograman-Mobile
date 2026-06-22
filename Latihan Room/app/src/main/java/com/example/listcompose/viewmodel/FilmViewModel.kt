package com.example.listcompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.listcompose.model.Film
import androidx.lifecycle.viewModelScope
import com.example.listcompose.data.entity.ReviewEntity
import com.example.listcompose.data.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FilmViewModel(private val repository: FilmRepository) : ViewModel() {
    private val _films = mutableStateOf(repository.getFilms())
    val films = _films

    fun getFilmById(filmId: Int): Film? = repository.getFilmById(filmId)

    fun getReviewsForFilm(filmId: Int): Flow<List<ReviewEntity>> = repository.getReviewsForFilm(filmId)

    fun addReview(filmId: Int, review: String) {
        viewModelScope.launch{
            repository.insertReview(
                ReviewEntity(filmId = filmId, review = review)
            )
        }
    }
}
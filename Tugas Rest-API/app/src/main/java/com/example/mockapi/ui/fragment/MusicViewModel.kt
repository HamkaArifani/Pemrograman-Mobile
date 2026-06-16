package com.example.mockapi.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mockapi.data.repository.MusicRepository
import com.example.mockapi.model.Music
import kotlinx.coroutines.launch

class MusicViewModel(private val musicRepository: MusicRepository): ViewModel(){
    private val _music = MutableLiveData<Music?>()
    val music: LiveData<Music?> = _music

    fun fetchMusic(){
        viewModelScope.launch {
            try {
                val result = musicRepository.getMusicDetail()
                _music.postValue(result.getOrNull())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}
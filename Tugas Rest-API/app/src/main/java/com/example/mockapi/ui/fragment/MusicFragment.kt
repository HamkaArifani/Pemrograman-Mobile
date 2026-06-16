package com.example.mockapi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mockapi.NetworkModule
import com.example.mockapi.data.remote.ApiService
import com.example.mockapi.data.repository.MusicRepository
import com.example.mockapi.databinding.FragmentMusicBinding
import com.example.mockapi.model.Music


class MusicFragment: Fragment() {

    private var _binding : FragmentMusicBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MusicViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiService = ApiService(NetworkModule.httpClient)
        val repository = MusicRepository(apiService)
        viewModel = MusicViewModel(repository)

        viewModel.fetchMusic()

        viewModel.music.observe(viewLifecycleOwner){ music ->
            binding.tvMockAPI.text = """
                Title: ${music?.title}
                Composer: ${music?.composer}
                Duration: ${music?.duration}
                Made For: ${music?.madeFor}
            """.trimIndent()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
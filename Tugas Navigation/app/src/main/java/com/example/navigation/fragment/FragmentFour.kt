package com.example.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.databinding.FragmentFourBinding
import com.example.navigation.databinding.FragmentTwoBinding
import kotlin.getValue

class FragmentFour : Fragment(R.layout.fragment_four) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFourBinding.bind(view)
        val args : FragmentOneArgs by navArgs()

        binding.tvPageText4.text = getString(R.string.page_number, args.pageNumber)

        binding.btnToPage5.setOnClickListener {
            val action = FragmentFourDirections.actionFourToFive(pageNumber = "Five")
            findNavController().navigate(action)
        }
    }
}
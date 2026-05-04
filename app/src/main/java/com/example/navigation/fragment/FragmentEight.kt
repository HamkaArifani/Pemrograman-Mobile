package com.example.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.databinding.FragmentEightBinding
import com.example.navigation.databinding.FragmentSixBinding
import kotlin.getValue

class FragmentEight : Fragment(R.layout.fragment_eight) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentEightBinding.bind(view)
        val args : FragmentOneArgs by navArgs()

        binding.tvPageText8.text = getString(R.string.page_number, args.pageNumber)

        binding.btnToPage9.setOnClickListener {
            val action = FragmentEightDirections.actionEightToNine(pageNumber = "Nine")
            findNavController().navigate(action)
        }
    }
}
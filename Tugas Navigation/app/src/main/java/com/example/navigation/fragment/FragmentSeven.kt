package com.example.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.databinding.FragmentSevenBinding
import com.example.navigation.databinding.FragmentSixBinding
import kotlin.getValue
import kotlin.random.Random

class FragmentSeven : Fragment(R.layout.fragment_seven) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSevenBinding.bind(view)
        val args : FragmentOneArgs by navArgs()

        binding.tvPageText7.text = getString(R.string.page_number, args.pageNumber)

        binding.btnToPage8.setOnClickListener {
            val action = FragmentSevenDirections.actionSevenToEight(pageNumber = "Eight")
            findNavController().navigate(action)
        }
    }

}
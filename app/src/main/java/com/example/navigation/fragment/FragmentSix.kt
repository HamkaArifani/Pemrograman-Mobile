package com.example.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.databinding.FragmentSixBinding
import com.example.navigation.databinding.FragmentTwoBinding
import kotlin.getValue

class FragmentSix : Fragment(R.layout.fragment_six) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSixBinding.bind(view)
        val args : FragmentOneArgs by navArgs()

        binding.tvPageText6.text = getString(R.string.page_number, args.pageNumber)

        binding.btnToPage7.setOnClickListener {
            val action = FragmentSixDirections.actionSixToSeven(pageNumber = "Seven")
            findNavController().navigate(action)
        }
    }
}
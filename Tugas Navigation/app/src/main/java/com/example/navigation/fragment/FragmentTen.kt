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
import com.example.navigation.databinding.FragmentTenBinding
import kotlin.getValue

class FragmentTen : Fragment(R.layout.fragment_ten) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTenBinding.bind(view)
        val args : FragmentOneArgs by navArgs()

        binding.tvPageText10.text = getString(R.string.page_number, args.pageNumber)

        binding.btnToPage1.setOnClickListener {
            val action = FragmentTenDirections.actionTenToOne(pageNumber = "One")
            findNavController().navigate(action)
        }
    }
}
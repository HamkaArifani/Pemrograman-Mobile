package com.example.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.databinding.FragmentNineBinding
import com.example.navigation.databinding.FragmentSixBinding
import kotlin.getValue

class FragmentNine : Fragment(R.layout.fragment_nine) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNineBinding.bind(view)
        val args : FragmentOneArgs by navArgs()

        binding.tvPageText9.text = getString(R.string.page_number, args.pageNumber)

        binding.btnToPage10.setOnClickListener {
            val action = FragmentNineDirections.actionNineToTen(pageNumber = "Ten")
            findNavController().navigate(action)
        }
    }
}
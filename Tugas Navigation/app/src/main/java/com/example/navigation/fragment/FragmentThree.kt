package com.example.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.databinding.FragmentThreeBinding
import com.example.navigation.databinding.FragmentTwoBinding
import kotlin.getValue

class FragmentThree : Fragment(R.layout.fragment_three) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentThreeBinding.bind(view)
        val args : FragmentOneArgs by navArgs()

        binding.tvPageText3.text = getString(R.string.page_number, args.pageNumber)

        binding.btnToPage4.setOnClickListener {
            val action = FragmentThreeDirections.actionThreeToFour(pageNumber = "Four")
            findNavController().navigate(action)
        }
    }
}
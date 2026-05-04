package com.example.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.databinding.FragmentFiveBinding
import com.example.navigation.databinding.FragmentTwoBinding
import kotlin.getValue

class FragmentFive : Fragment(R.layout.fragment_five) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFiveBinding.bind(view)
        val args : FragmentOneArgs by navArgs()

        binding.tvPageText5.text = getString(R.string.page_number, args.pageNumber)

        binding.btnToPage6.setOnClickListener {
            val action = FragmentFiveDirections.actionFiveToSix(pageNumber = "Six")
            findNavController().navigate(action)
        }
    }
}
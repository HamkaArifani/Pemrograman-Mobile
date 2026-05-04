package com.example.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.R
import com.example.navigation.databinding.FragmentOneBinding
import com.example.navigation.databinding.FragmentTwoBinding
import kotlin.getValue


class FragmenTwo : Fragment(R.layout.fragment_two) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTwoBinding.bind(view)
        val args : FragmentOneArgs by navArgs()

        binding.tvPageText2.text = getString(R.string.page_number, args.pageNumber)

        binding.btnToPage3.setOnClickListener {
            val action = FragmenTwoDirections.actionTwoToThree(pageNumber = "Three")
            findNavController().navigate(action)
        }
    }
}
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
import kotlin.getValue


class FragmentOne : Fragment(R.layout.fragment_one) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentOneBinding.bind(view)
        val args : FragmentOneArgs by navArgs()

        binding.tvPageText1.text = getString(R.string.page_number, args.pageNumber)

        binding.btnToPage2.setOnClickListener {
            val action = FragmentOneDirections.actionOneToTwo(pageNumber = "Two")
            findNavController().navigate(action)
        }
    }
}
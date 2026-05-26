package com.example.rvexercise.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.rvexercise.adapter.ItemListAdapter
import com.example.rvexercise.databinding.FragmentHomeBinding
import com.example.rvexercise.viewmodel.ItemViewModel

class HomeFragment: Fragment() {
    private val viewModel : ItemViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHome.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(requireContext())

        viewModel.itemlist.observe(viewLifecycleOwner){listData->
            val itemListAdapter = ItemListAdapter(
                items = listData,

                onListClicked = {item->
                    Toast.makeText(
                        requireContext(),
                        "Item telah ditekan untuk item ${item.id}",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                onButtonClicked = {item->
                    Toast.makeText(
                        requireContext(),
                        "Tombol telah ditekan untuk tombol ${item.id}",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                onSwitchClicked = {item, isChecked ->
                    val status = if (isChecked) "hidup" else "mati"
                    Toast.makeText(
                        requireContext(),
                        "Switch $status pada item ${item.id}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            )
            binding.rvHome.adapter = itemListAdapter
        }
        viewModel.loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.rvexercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rvexercise.R
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.rvexercise.databinding.ItemHomeBinding
import com.example.rvexercise.model.ItemData

class ItemListAdapter (
    private val items: List<ItemData>,
    private val onListClicked: (ItemData)-> Unit,
    private val onButtonClicked: (ItemData)->Unit,
    private val onSwitchClicked: (ItemData, Boolean)-> Unit
): RecyclerView.Adapter<ItemListAdapter.ItemListViewHolder>(){

    class ItemListViewHolder(val binding: ItemHomeBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(
            item: ItemData,
            onListClicked: (ItemData) -> Unit,
            onButtonClicked: (ItemData) -> Unit,
            onSwitchClicked: (ItemData, Boolean) -> Unit
        ){
            binding.apply {
                ivItem.setImageResource(item.image)
                tvTitle.text = root.context.getString(item.title)
                tvDescItem.text = root.context.getString(item.description)
                buttonItem.setOnClickListener { onButtonClicked(item) }
                switchItem.setOnCheckedChangeListener(null)
                switchItem.isChecked=item.isSwitched
                switchItem.setOnCheckedChangeListener { _, isChecked->
                    onSwitchClicked(item, isChecked)
                }
                root.setOnClickListener { onListClicked(item) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false )
        return ItemListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
        val item = items[position]
        val context = holder.itemView.context
        holder.bind(item, onListClicked, onButtonClicked, onSwitchClicked)
        if(position % 2 == 0){
            holder.binding.cvItem.setCardBackgroundColor(ContextCompat.getColor(context, R.color.oddItem))
        }
        else{
            holder.binding.cvItem.setCardBackgroundColor(ContextCompat.getColor(context, R.color.evenItem))
        }
    }

    override fun getItemCount(): Int = items.size
}
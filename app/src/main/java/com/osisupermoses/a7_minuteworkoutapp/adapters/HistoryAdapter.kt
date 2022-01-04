package com.osisupermoses.a7_minuteworkoutapp.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.osisupermoses.a7_minuteworkoutapp.R
import com.osisupermoses.a7_minuteworkoutapp.databinding.ItemHistoryRowBinding

class HistoryAdapter(
    private val items: ArrayList<String>
) : RecyclerView.Adapter<HistoryAdapter.AdapterViewHolder>() {

    inner class AdapterViewHolder(binding: ItemHistoryRowBinding)
        : RecyclerView.ViewHolder(binding.root) {
        val llHistoryItemMain = binding.llHistoryItemMain
        val tvItem = binding.tvItem
        val tvPosition = binding.tvPosition
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(ItemHistoryRowBinding.inflate
            (LayoutInflater.from(parent.context),
            parent, false)
        )
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val date: String = items[position]
        holder.tvPosition.text = (position + 1).toString()
        holder.tvItem.text = date

        if (position % 2 == 0) {
            holder.llHistoryItemMain.setBackgroundColor(
                Color.parseColor("#EBEBEB"))
        } else {
            holder.llHistoryItemMain.setBackgroundColor(
                ContextCompat.getColor(holder.itemView.context,
                    R.color.white))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
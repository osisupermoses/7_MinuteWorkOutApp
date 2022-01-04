package com.osisupermoses.a7_minuteworkoutapp.adapters


import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.osisupermoses.a7_minuteworkoutapp.model.ExerciseModel
import com.osisupermoses.a7_minuteworkoutapp.R
import com.osisupermoses.a7_minuteworkoutapp.databinding.ItemExerciseStatusBinding

class ExerciseStatusAdapter(
    private var items: ArrayList<ExerciseModel>
) : RecyclerView.Adapter<ExerciseStatusAdapter.ExerciseStatusViewHolder>() {

    inner class ExerciseStatusViewHolder(itemBinding: ItemExerciseStatusBinding)
        : RecyclerView.ViewHolder(itemBinding.root) {
                val tvItem = itemBinding.tvItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseStatusViewHolder {
        return ExerciseStatusViewHolder(ItemExerciseStatusBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExerciseStatusViewHolder, position: Int) {
        val model = items[position]
        holder.tvItem.text = model.getId().toString()

        when{
            model.getIsSelected() -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context,
                        R.drawable.item_circular_thin_color_accent_border
                    )
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
            model.getIsCompleted() -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context,
                        R.drawable.item_circular_color_accent_background
                    )
                holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))
            }
            else -> {
                holder.tvItem.background =
                    ContextCompat.getDrawable(holder.itemView.context,
                        R.drawable.item_circular_color_gray_background
                    )
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}
package com.tb.task.ui.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hike.assignment.ui.interfaces.ListItemClicked
import com.tb.task.R
import com.tb.task.databinding.ItemClassBinding
import com.tb.task.models.entities.TBClass
import com.tb.task.ui.ImageLoaderUtils

class AdapterClasses(val point: Point, val itemClickListerner: ListItemClicked) :
    RecyclerView.Adapter<AdapterClasses.MyHolder>() {


    val classList = ArrayList<TBClass>()
    val width = (point.x / 1.2).toInt()
    val height = (width / 2.236).toInt()

    inner class MyHolder(val binding: ItemClassBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            val layoutParams = binding.ivFaculty.layoutParams
            if (layoutParams.width != width) {
                layoutParams.width = width
                layoutParams.height = height
                binding.ivFaculty.layoutParams = layoutParams
            }
        }
        fun complexDataAddition(classData:TBClass){
            var drawable = binding.parent.background as LayerDrawable
            val bg = drawable.findDrawableByLayerId(R.id.bg) as GradientDrawable
            if (position % 2 == 0) {
                bg.color = ColorStateList.valueOf(Color.parseColor("#597e5d"))
            } else {
                bg.color = ColorStateList.valueOf(Color.parseColor("#5f6c8f"))
            }
            ImageLoaderUtils.setImage(
                binding.ivFaculty,
                classList[position].classInfo?.facultiesImage,
                width,
                height
            )
            binding.cardView.setOnClickListener {
                itemClickListerner.itemClicked(
                    adapterPosition,
                    classData,
                    FLAG_ITEM_CLICKED
                )
            }
        }
    }

    fun appendList(newLIst: ArrayList<TBClass>) {
        val i = classList.size
        classList.addAll(newLIst)
        notifyItemRangeInserted(i, newLIst.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_class,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val classData = classList[position]

        holder.binding.classData = classData
        holder.complexDataAddition(classData)
    }

    override fun getItemCount(): Int {
        return classList.size
    }

    fun clear() {
        classList.clear()
        notifyDataSetChanged()
    }

    companion object {
        val FLAG_ITEM_CLICKED = 2
    }
}
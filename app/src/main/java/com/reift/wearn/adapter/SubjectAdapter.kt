package com.reift.wearn.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reift.wearn.R
import com.reift.wearn.data.Dummy
import com.reift.wearn.databinding.ItemSubjectBinding

class SubjectAdapter() :
    RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {

    private val selectedSubject = arrayListOf<String>()

    class SubjectViewHolder(val binding: ItemSubjectBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SubjectViewHolder(
        ItemSubjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        holder.apply {
            binding.apply {
                val subject = Dummy.listSubject[position]
                tvSubject.text = subject
                itemView.setOnClickListener {
                    val primaryColor = itemView.context.resources.getColor(R.color.primary_color)
                    val whiteColor = itemView.context.resources.getColor(R.color.white)
                    if (!selectedSubject.contains(subject)) {
                        root.setCardBackgroundColor(primaryColor)
                        tvSubject.setTextColor(whiteColor)
                        selectedSubject.add(subject)
                    } else {
                        root.setCardBackgroundColor(whiteColor)
                        tvSubject.setTextColor(primaryColor)
                        selectedSubject.remove(subject)
                    }


                }
            }

        }
    }

    override fun getItemCount() = Dummy.listSubject.size

}
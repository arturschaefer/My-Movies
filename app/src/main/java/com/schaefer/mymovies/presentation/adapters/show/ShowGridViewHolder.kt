package com.schaefer.mymovies.presentation.adapters.show

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.schaefer.mymovies.R
import com.schaefer.mymovies.databinding.ItemCardImageBinding
import com.schaefer.mymovies.presentation.model.Show

class ShowGridViewHolder(
    private val binding: ItemCardImageBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(show: Show, itemClickListener: OnItemClickListener) {
        binding.tvItemShowName.text = show.name

        Glide.with(itemView).load(show.image?.original).centerCrop()
            .placeholder(R.drawable.show_placeholder).into(binding.ivItemPoster)

        itemView.setOnClickListener { itemClickListener.onItemClick(show) }
    }

    companion object {
        fun create(parent: ViewGroup): ShowGridViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card_image, parent, false)

            val binding = ItemCardImageBinding.bind(view)

            return ShowGridViewHolder(
                binding
            )
        }
    }
}
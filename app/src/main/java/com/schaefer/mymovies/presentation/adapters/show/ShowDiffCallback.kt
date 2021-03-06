package com.schaefer.mymovies.presentation.adapters.show

import androidx.recyclerview.widget.DiffUtil
import com.schaefer.mymovies.presentation.model.Show

class ShowDiffCallback: DiffUtil.ItemCallback<Show>() {
    override fun areItemsTheSame(oldItem: Show, newItem: Show): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Show, newItem: Show): Boolean {
        return oldItem == newItem
    }
}
package com.schaefer.mymovies.presentation.adapters.home

import androidx.recyclerview.widget.DiffUtil
import com.schaefer.mymovies.presentation.model.ListShow

class HomeListDiffCallback(
    private val oldList: ListShow,
    private val newList: ListShow
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList.listShow[oldItemPosition].id == newList.listShow[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldList.listShow.size
    }

    override fun getNewListSize(): Int {
        return newList.listShow.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList.listShow[oldItemPosition] == newList.listShow[newItemPosition]
    }
}
package com.schaefer.mymovies.presentation.adapters.show

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.schaefer.mymovies.presentation.model.Show

class ShowsRxAdapter(
    private val itemClickListener: OnItemClickListener
) : PagingDataAdapter<Show, ShowGridViewHolder>(ShowDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowGridViewHolder {
        return ShowGridViewHolder.create(
            parent
        )
    }

    override fun onBindViewHolder(holder: ShowGridViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, itemClickListener)
        }
    }
}
package com.schaefer.mymovies.presentation.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.schaefer.mymovies.R
import com.schaefer.mymovies.presentation.model.ListShow

class HomeListAdapter : RecyclerView.Adapter<HomeListItemViewHolder>() {
    var shows = ListShow(emptyList())
        set(value) {
            val result = DiffUtil.calculateDiff(
                HomeListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_image, parent, false)

        return HomeListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeListItemViewHolder, position: Int) {
        holder.bind(shows.listShow[position])
    }

    override fun getItemCount(): Int = shows.size()
}
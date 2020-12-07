package com.schaefer.mymovies.presentation.adapters.show

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.schaefer.mymovies.R
import com.schaefer.mymovies.presentation.model.ListShow

class ShowListAdapter(val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<ShowListItemViewHolder>() {

    var shows = ListShow(emptyList())
        set(value) {
            val result = DiffUtil.calculateDiff(
                ShowListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card_image, parent, false)

        return ShowListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowListItemViewHolder, position: Int) {
        holder.bind(shows.listShow[position], itemClickListener)
    }

    override fun getItemCount(): Int = shows.size()
}